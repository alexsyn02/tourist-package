<%@ page import="java.util.List" %>
<%@ page import="model.entity.TouristVoucher" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="controller.utils.BundleConstants" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<html>
<head>
    <title>New</title>
    <link rel="stylesheet" href="style.css">
    <%
        ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
        if(bundle == null) {
            bundle = ResourceBundle.getBundle("lang_en", new Locale("en", "US"));
        }
    %>
</head>
<body>

    <form action="filter" method="get">

        <p><%=bundle.getString(BundleConstants.VOUCHER_TYPE)%>:</p>

        <label>
            <input type="checkbox" name="voucherType" value="<%=bundle.getString(BundleConstants.RECREATION)%>">
            <span><%=bundle.getString(BundleConstants.RECREATION)%></span>
        </label>

        <label>
            <input type="checkbox" name="voucherType" value="<%=bundle.getString(BundleConstants.EXCURSION)%>">
            <span><%=bundle.getString(BundleConstants.EXCURSION)%></span>
        </label>

        <label>
            <input type="checkbox" name="voucherType" value="<%=bundle.getString(BundleConstants.TREATMENT)%>">
            <span><%=bundle.getString(BundleConstants.TREATMENT)%></span>
        </label>

        <label>
            <input type="checkbox" name="voucherType" value="<%=bundle.getString(BundleConstants.SHOPPING)%>">
            <span><%=bundle.getString(BundleConstants.SHOPPING)%></span>
        </label>

        <label>
            <input type="checkbox" name="voucherType" value="<%=bundle.getString(BundleConstants.CRUISE)%>">
            <span><%=bundle.getString(BundleConstants.CRUISE)%></span>
        </label>

        <p><%=bundle.getString(BundleConstants.PRICE)%>:</p>

        <label>
            <span><%=bundle.getString(BundleConstants.MINIMUM_PRICE)%>: </span>
            <input type="number" name="minPrice">
        </label>

        <label>
            <span><%=bundle.getString(BundleConstants.MAXIMUM_PRICE)%>: </span>
            <input type="number" name="maxPrice">
        </label>

        <p><%=bundle.getString(BundleConstants.DAYS_AMOUNT)%>:</p>

        <label>
            <span><%=bundle.getString(BundleConstants.MINIMUM_DAYS)%>: </span>
            <input type="number" name="minDays">
        </label>

        <label>
            <span><%=bundle.getString(BundleConstants.MAXIMUM_DAYS)%>: </span>
            <input type="number" name="maxDays">
        </label>

        <p><%=bundle.getString(BundleConstants.TRANSPORT_TYPE)%>:</p>

        <label>
            <input type="checkbox" name="transport" value="<%=bundle.getString(BundleConstants.AUTOMOBILE)%>">
            <span><%=bundle.getString(BundleConstants.AUTOMOBILE)%></span>
        </label>

        <label>
            <input type="checkbox" name="transport" value="<%=bundle.getString(BundleConstants.PLANE)%>">
            <span><%=bundle.getString(BundleConstants.PLANE)%></span>
        </label>

        <label>
            <input type="checkbox" name="transport" value="<%=bundle.getString(BundleConstants.TRAIN)%>">
            <span><%=bundle.getString(BundleConstants.TRAIN)%></span>
        </label>

        <label>
            <input type="checkbox" name="transport" value="<%=bundle.getString(BundleConstants.BUS)%>">
            <span><%=bundle.getString(BundleConstants.BUS)%></span>
        </label>

        <p><%=bundle.getString(BundleConstants.DISHES)%>:</p>

        <label>
            <input type="checkbox" name="dishes" value="<%=bundle.getString(BundleConstants.ICE_CREAM)%>">
            <span><%=bundle.getString(BundleConstants.ICE_CREAM)%></span>
        </label>

        <label>
            <input type="checkbox" name="dishes" value="<%=bundle.getString(BundleConstants.SOUP)%>">
            <span><%=bundle.getString(BundleConstants.SOUP)%></span>
        </label>

        <label>
            <input type="checkbox" name="dishes" value="<%=bundle.getString(BundleConstants.PASTA)%>">
            <span><%=bundle.getString(BundleConstants.PASTA)%></span>
        </label>

        <label>
            <input type="checkbox" name="dishes" value="<%=bundle.getString(BundleConstants.WINE)%>">
            <span><%=bundle.getString(BundleConstants.WINE)%></span>
        </label>

        <p><%=bundle.getString(BundleConstants.SORTING_BY)%>:</p>

        <label>
            <input type="radio" name="sortByPrice" value="<%=bundle.getString(BundleConstants.ASCENDING)%>">
            <span><%=bundle.getString(BundleConstants.ASCENDING)%></span>
        </label>

        <label>
            <input type="radio" name="sortByPrice" value="<%=bundle.getString(BundleConstants.DESCENDING)%>">
            <span><%=bundle.getString(BundleConstants.DESCENDING)%></span>
        </label>

        <label>
            <input type="radio" name="sortByPrice" value="<%=bundle.getString(BundleConstants.NON_SORTED)%>" checked="checked">
            <span><%=bundle.getString(BundleConstants.NON_SORTED)%></span>
        </label>

        <button><%=bundle.getString(BundleConstants.SUBMIT)%></button>
    </form>

    <form action="filter" method="post">
        <button name="Reset"><%=bundle.getString(BundleConstants.RESET_FILTERS)%></button>
    </form>

    <%
        List<TouristVoucher> touristVouchers = (ArrayList<TouristVoucher>) request.getSession().getAttribute("filteredVouchers");

        for (TouristVoucher touristVoucher : touristVouchers) {
            out.print("<div class='tourist-voucher'>");
            out.print("<p> <b>" + bundle.getString(BundleConstants.VOUCHER_TYPE) + "</b>: " + touristVoucher.getTouristType().getTouristType() + "</p>");
            out.print("<p> <b>" + bundle.getString(BundleConstants.TRANSPORT_TYPE) + "</b>: " + touristVoucher.getTransport().getType() + "</p>");
            out.print("<p> <b>" + bundle.getString(BundleConstants.DISHES) + "</b>: " + touristVoucher.getFood().getFirstCourse() + ", " + touristVoucher.getFood().getSecondCourse()
                    + ", " + touristVoucher.getFood().getDessert() + ", " + touristVoucher.getFood().getDrink() + "</p>");
            out.print("<p> <b>" + bundle.getString(BundleConstants.DAYS_AMOUNT) + "</b>: " + touristVoucher.getAmountDays().getDays() + "</p>");
            out.print("<p> <b>" + bundle.getString(BundleConstants.PRICE) + "</b>: " + touristVoucher.getPrice() + "</p>");
            out.print("</div>");
        }


    if (touristVouchers.size() == 0) {
        out.print("<p>" + bundle.getString(BundleConstants.EMPTY_LIST) + "</p>");
    }

    %>
</body>
</html>