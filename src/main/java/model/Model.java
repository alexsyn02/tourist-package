package model;

import model.entity.TouristVoucher;

import java.util.List;

/**
 * Created by Alexandr on 21.08.2017.
 */
public class Model {

    private List<TouristVoucher> touristVouchers;

    public List<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    public void setTouristVouchers(List<TouristVoucher> touristVouchers) {
        this.touristVouchers = touristVouchers;
    }


}
