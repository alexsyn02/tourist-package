package controller;

import controller.utils.TouristVoucherUtils;
import model.Model;
import model.entity.Transport;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alexandr on 23.08.2017.
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void run() {

        TouristVoucherUtils touristVoucherUtils = new TouristVoucherUtils();
        String[] transports = {"automobile", "plane"};

        model.setTouristVouchers(TouristVoucherUtils.createSampleList(ResourceBundle.getBundle("lang", new Locale("en", "US"))));

        view.showTouristVouchers(model.getTouristVouchers());

        view.showTouristVouchers(touristVoucherUtils.getTouristVouchersByPriceDescending(model.getTouristVouchers()));
        view.showTouristVouchers(touristVoucherUtils.getTouristVouchersByPriceAscending(model.getTouristVouchers()));

        view.showTouristVouchers(touristVoucherUtils.filterTouristVouchersByTransport(model.getTouristVouchers(), transports));

        view.showTouristVouchers(model.getTouristVouchers());
    }
}
