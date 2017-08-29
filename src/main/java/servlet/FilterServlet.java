package servlet;

import controller.utils.BundleConstants;
import controller.utils.TouristVoucherUtils;
import model.entity.TouristType;
import model.entity.TouristVoucher;
import model.entity.Transport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Alexandr on 23.08.2017.
 */
@WebServlet("/filter")
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
        String temp;
        TouristVoucherUtils touristVoucherUtils = new TouristVoucherUtils();
        String[] voucherTypes = req.getParameterValues("voucherType");
        double minPrice;
        double maxPrice;
        double minDays;
        double maxDays;
        String[] dishes = req.getParameterValues("dishes");
        String[] transports = req.getParameterValues("transport");
        String sorting = req.getParameter("sortByPrice");
        List<TouristVoucher> vouchers = (ArrayList<TouristVoucher>) session.getAttribute("vouchers");

        if (!(temp = req.getParameter("minPrice")).equals("")) {
            minPrice = Double.parseDouble(temp);
        } else {
            minPrice = touristVoucherUtils.getMinPrice(vouchers);
        }

        if (!(temp = req.getParameter("maxPrice")).equals("")) {
            maxPrice = Double.parseDouble(temp);
        } else {
            maxPrice = touristVoucherUtils.getMaxPrice(vouchers);
        }

        if (!(temp = req.getParameter("minDays")).equals("")) {
            minDays = Double.parseDouble(temp);
        } else {
            minDays = touristVoucherUtils.getMinDays(vouchers);
        }

        if (!(temp = req.getParameter("maxDays")).equals("")) {
            maxDays = Double.parseDouble(temp);
        } else {
            maxDays = touristVoucherUtils.getMaxDays(vouchers);
        }

        vouchers = touristVoucherUtils.filterTouristVouchersByTouristType(vouchers, voucherTypes);
        vouchers = touristVoucherUtils.filterTouristVouchersByPrice(vouchers, minPrice, maxPrice);
        vouchers = touristVoucherUtils.filterTouristVouchersByDays(vouchers, minDays, maxDays);
        vouchers = touristVoucherUtils.filterTouristVouchersByFood(vouchers, dishes);
        vouchers = touristVoucherUtils.filterTouristVouchersByTransport(vouchers, transports);
        if (sorting.equals(bundle.getString(BundleConstants.ASCENDING))) {
            vouchers = touristVoucherUtils.getTouristVouchersByPriceAscending(vouchers);
        } else if (sorting.equals(bundle.getString(BundleConstants.DESCENDING))) {
            vouchers = touristVoucherUtils.getTouristVouchersByPriceDescending(vouchers);
        }

        session.setAttribute("filteredVouchers", vouchers);

        req.getRequestDispatcher("/new.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<TouristVoucher> vouchers = (ArrayList<TouristVoucher>) req.getSession().getAttribute("vouchers");

        session.setAttribute("filteredVouchers", vouchers);

        req.getRequestDispatcher("/new.jsp").forward(req, resp);
    }
}
