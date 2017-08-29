package model.entity;

public class TouristVoucher {

    private Transport transport;
    private Food food;
    private TouristType touristType;
    private Days amountDays;
    private int price;

    public TouristVoucher(Transport transport, Food food, TouristType touristType, Days amountDays, int price) {
        this.transport = transport;
        this.food = food;
        this.touristType = touristType;
        this.amountDays = amountDays;
        this.price = price;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public TouristType getTouristType() {
        return touristType;
    }

    public void setTouristType(TouristType touristType) {
        this.touristType = touristType;
    }

    public Days getAmountDays() {
        return amountDays;
    }

    public void setAmountDays(Days amountDays) {
        this.amountDays = amountDays;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TouristVoucher)) return false;

        TouristVoucher that = (TouristVoucher) o;

        if (getPrice() != that.getPrice()) return false;
        if (getTransport() != null ? !getTransport().equals(that.getTransport()) : that.getTransport() != null)
            return false;
        if (getFood() != null ? !getFood().equals(that.getFood()) : that.getFood() != null) return false;
        if (getTouristType() != null ? !getTouristType().equals(that.getTouristType()) : that.getTouristType() != null)
            return false;
        return getAmountDays() != null ? getAmountDays().equals(that.getAmountDays()) : that.getAmountDays() == null;
    }

    @Override
    public int hashCode() {
        int result = getTransport() != null ? getTransport().hashCode() : 0;
        result = 31 * result + (getFood() != null ? getFood().hashCode() : 0);
        result = 31 * result + (getTouristType() != null ? getTouristType().hashCode() : 0);
        result = 31 * result + (getAmountDays() != null ? getAmountDays().hashCode() : 0);
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "TouristVoucher{" +
                "transport=" + transport.toString() +
                ", food=" + food.toString() +
                ", touristType=" + touristType.toString() +
                ", amountDays=" + amountDays.toString() +
                ", price=" + price +
                '}' + '\n';
    }
}
