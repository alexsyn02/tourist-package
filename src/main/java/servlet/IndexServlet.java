package servlet;

import model.entity.*;
import controller.utils.TouristVoucherUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        ResourceBundle bundle = getBundle(req, resp);

        List<TouristVoucher> vouchers = TouristVoucherUtils.createSampleList(bundle);

        session.setAttribute("bundle", bundle);
        session.setAttribute("vouchers", vouchers);
        session.setAttribute("filteredVouchers", vouchers);

        req.getRequestDispatcher("/new.jsp").forward(req, resp);
    }

    private ResourceBundle getBundle(HttpServletRequest req, HttpServletResponse resp) {
        switch (req.getParameter("language")) {
            case "en":
                return ResourceBundle.getBundle("lang_en", new Locale("en", "US"));
            case "ru":
                return ResourceBundle.getBundle("lang_ru", new Locale("ru", "RU"));
            default:
                throw new RuntimeException("Unsupported language");
        }
    }
}