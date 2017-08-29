package model.entity;

/**
 * Created by Alexandr on 12.08.2017.
 */
public class Days {
    int days;

    public Days(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Days)) return false;

        Days days1 = (Days) o;

        return getDays() == days1.getDays();
    }

    @Override
    public int hashCode() {
        return getDays();
    }

    @Override
    public String toString() {
        return "Days{" +
                "days=" + days +
                '}';
    }
}
