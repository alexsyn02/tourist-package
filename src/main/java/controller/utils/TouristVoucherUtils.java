package controller.utils;

import model.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class TouristVoucherUtils {

    public List<TouristVoucher> getList() {

        final String url = "jdbc:mysql://localhost:3306/tourist_package?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "root";

        Connection connection;
        Statement statement;
        ResultSet resultSet;
        List<TouristVoucher> touristVouchers = new ArrayList<>();

        String query = "select * from travel_vouchers";

        // Connecting to database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Initializating @touristTypeList from rows in database
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String touristTypeData = resultSet.getString(2);
                String firstDishData = resultSet.getString(3);
                String secondDishData = resultSet.getString(4);
                String dessertData = resultSet.getString(5);
                String drinkData = resultSet.getString(6);
                String transportData = resultSet.getString(7);
                int priceData = resultSet.getInt(8);
                int daysData = resultSet.getInt(9);
                Transport transport = new Transport(transportData);
                Food food = new Food(firstDishData, secondDishData, dessertData, drinkData);
                TouristType touristType = new TouristType(touristTypeData);
                Days days = new Days(daysData);
                TouristVoucher touristVoucher = new TouristVoucher(transport, food, touristType, days, priceData);
                touristVouchers.add(touristVoucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return touristVouchers;
    }

    public static List<TouristVoucher> createSampleList(ResourceBundle bundle) {

        List<TouristVoucher> touristVoucherList = new ArrayList<>();

        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(7), 5500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(7), 7500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(7), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(7), 4000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(10), 6500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(10), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(10), 6000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(10), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(14), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(14), 10500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(14), 8000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.RECREATION)), new Days(14), 7000));

        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(7), 5500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(7), 7500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(7), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(7), 4000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(10), 6500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(10), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(10), 6000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(10), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(14), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(14), 10500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(14), 8000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.EXCURSION)), new Days(14), 7000));

        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(7), 5500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(7), 7500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(7), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(7), 4000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(10), 6500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(10), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(10), 6000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(10), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(14), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(14), 10500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(14), 8000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.TREATMENT)), new Days(14), 7000));

        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(7), 5500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(7), 7500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(7), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(7), 4000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(10), 6500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(10), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(10), 6000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(10), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(14), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(14), 10500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(14), 8000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.SHOPPING)), new Days(14), 7000));

        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(7), 5500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(7), 7500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(7), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(7), 4000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(10), 6500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(10), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(10), 6000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(10), 5000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.AUTOMOBILE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(14), 8500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.PLANE)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WINE)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(14), 10500));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.TRAIN)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(14), 8000));
        touristVoucherList.add(new TouristVoucher(new Transport(bundle.getString(BundleConstants.BUS)), new Food(bundle.getString(BundleConstants.SOUP), bundle.getString(BundleConstants.PASTA), bundle.getString(BundleConstants.ICE_CREAM), bundle.getString(BundleConstants.WATER)), new TouristType(bundle.getString(BundleConstants.CRUISE)), new Days(14), 7000));

        return touristVoucherList;
    }

    public List<TouristVoucher> filterTouristVouchersByTouristType(List<TouristVoucher> vouchers, String ... touristTypes) {

        if (touristTypes == null) {
            return vouchers;
        }

        List<TouristVoucher> filteredTouristVouchers = new ArrayList<>();

        for (TouristVoucher touristVoucher : vouchers) {

            String voucherTouristType = touristVoucher.getTouristType().getTouristType();

            for (String touristType : touristTypes) {
                if (voucherTouristType.equals(touristType)) {
                    filteredTouristVouchers.add(touristVoucher);
                    break;
                }
            }
        }

        return filteredTouristVouchers;
    }

    public List<TouristVoucher> filterTouristVouchersByPrice(List<TouristVoucher> vouchers, double min, double max) {
        List<TouristVoucher> filteredTouristVouchers = new ArrayList<>();
        double price;

        for (TouristVoucher touristVoucher : vouchers) {

            price = touristVoucher.getPrice();

            if (price >= min && price <= max) {
                filteredTouristVouchers.add(touristVoucher);
            }
        }

        return filteredTouristVouchers;
    }

    public List<TouristVoucher> filterTouristVouchersByDays(List<TouristVoucher> vouchers, double min, double max) {
        List<TouristVoucher> filteredTouristVouchers = new ArrayList<>();
        double days;

        for (TouristVoucher touristVoucher : vouchers) {

            days = touristVoucher.getAmountDays().getDays();

            if (days >= min && days <= max) {
                filteredTouristVouchers.add(touristVoucher);
            }
        }

        return filteredTouristVouchers;
    }

    public List<TouristVoucher> filterTouristVouchersByFood(List<TouristVoucher> vouchers, String ... dishes) {

        if (dishes == null) {
            return vouchers;
        }

        List<TouristVoucher> filteredTouristVouchers = new ArrayList<>();

        for (TouristVoucher touristVoucher : vouchers) {

            String firstCourse = touristVoucher.getFood().getFirstCourse();
            String secondCourse = touristVoucher.getFood().getSecondCourse();
            String dessert = touristVoucher.getFood().getDessert();
            String drink = touristVoucher.getFood().getDrink();

            for (String dish : dishes) {
                if (firstCourse.equals(dish) || secondCourse.equals(dish) || dessert.equals(dish) || drink.equals(dish)) {
                    filteredTouristVouchers.add(touristVoucher);
                    break;
                }
            }
        }

        return filteredTouristVouchers;
    }

    public List<TouristVoucher> filterTouristVouchersByTransport(List<TouristVoucher> vouchers, String ... transports) {

        if (transports == null) {
            return vouchers;
        }

        List<TouristVoucher> filteredTouristVouchers = new ArrayList<>();

        for (TouristVoucher touristVoucher : vouchers) {

            String voucherTransport = touristVoucher.getTransport().getType();

            for (String transport : transports) {
                if (voucherTransport.equals(transport)) {
                    filteredTouristVouchers.add(touristVoucher);
                    break;
                }
            }
        }

        return filteredTouristVouchers;
    }

    public List<TouristVoucher> getTouristVouchersByPriceDescending(List<TouristVoucher> vouchers) {
        List<TouristVoucher> touristVouchersByPriceDescending = new ArrayList<>();

        touristVouchersByPriceDescending.addAll(vouchers);

        for(int i = 0; i < touristVouchersByPriceDescending.size(); i++) {
            for(int j = 1; j < touristVouchersByPriceDescending.size() - i; j++) {
                if (touristVouchersByPriceDescending.get(j - 1).getPrice() < touristVouchersByPriceDescending.get(j).getPrice()) {
                    Collections.swap(touristVouchersByPriceDescending, j - 1, j);
                }
            }
        }

        return touristVouchersByPriceDescending;
    }

    public List<TouristVoucher> getTouristVouchersByPriceAscending(List<TouristVoucher> vouchers) {
        List<TouristVoucher> touristVouchersByPriceAscending = new ArrayList<>();

        touristVouchersByPriceAscending.addAll(vouchers);

        for(int i = 0; i < touristVouchersByPriceAscending.size(); i++) {
            for(int j = 1; j < touristVouchersByPriceAscending.size() - i; j++) {
                if (touristVouchersByPriceAscending.get(j - 1).getPrice() > touristVouchersByPriceAscending.get(j).getPrice()) {
                    Collections.swap(touristVouchersByPriceAscending, j - 1, j);
                }
            }
        }

        return touristVouchersByPriceAscending;
    }

    public double getMinPrice(List<TouristVoucher> vouchers) {

        if (vouchers == null) {
            throw new NullPointerException();
        }

        double min = vouchers.get(0).getPrice();

        for (TouristVoucher touristVoucher : vouchers) {

            double currentPrice = touristVoucher.getPrice();

            if (currentPrice < min) {
                min = currentPrice;
            }
        }

        return min;
    }

    public double getMaxPrice(List<TouristVoucher> vouchers) {

        if (vouchers == null) {
            throw new NullPointerException();
        }

        double max = vouchers.get(0).getPrice();

        for (TouristVoucher touristVoucher : vouchers) {

            double currentPrice = touristVoucher.getPrice();

            if (currentPrice > max) {
                max = currentPrice;
            }
        }

        return max;
    }

    public double getMinDays(List<TouristVoucher> vouchers) {

        if (vouchers == null) {
            throw new NullPointerException();
        }

        double min = vouchers.get(0).getAmountDays().getDays();

        for (TouristVoucher touristVoucher : vouchers) {

            double currentDays = touristVoucher.getAmountDays().getDays();

            if (currentDays < min) {
                min = currentDays;
            }
        }

        return min;
    }

    public double getMaxDays(List<TouristVoucher> vouchers) {

        if (vouchers == null) {
            throw new NullPointerException();
        }

        double max = vouchers.get(0).getAmountDays().getDays();

        for (TouristVoucher touristVoucher : vouchers) {

            double currentDays = touristVoucher.getAmountDays().getDays();

            if (currentDays > max) {
                max = currentDays;
            }
        }

        return max;
    }
}
