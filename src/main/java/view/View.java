package view;

import model.entity.TouristVoucher;

import java.util.List;

/**
 * Created by Alexandr on 23.08.2017.
 */
public class View {

    public void showTouristVouchers(List<TouristVoucher> touristVouchers) {

        System.out.println("________________________________________________________________________________");

        for (TouristVoucher touristVoucher : touristVouchers) {
            System.out.println(touristVoucher.getTouristType());
            System.out.println(touristVoucher.getFood());
            System.out.println(touristVoucher.getTransport());
            System.out.println(touristVoucher.getAmountDays());
            System.out.println(touristVoucher.getPrice());
        }

        System.out.println("________________________________________________________________________________");
        System.out.println();
    }
}
