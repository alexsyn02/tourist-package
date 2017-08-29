package model.entity;

/**
 * Created by Alexandr on 10.08.2017.
 */
public class TouristType {
    private String touristType;

    public TouristType(String touristType) {
        this.touristType = touristType;
    }

    public String getTouristType() {
        return touristType;
    }

    public void setTouristType(String touristType) {
        this.touristType = touristType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TouristType)) return false;

        TouristType that = (TouristType) o;

        return getTouristType() != null ? getTouristType().equals(that.getTouristType()) : that.getTouristType() == null;
    }

    @Override
    public int hashCode() {
        return getTouristType() != null ? getTouristType().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TouristType{" +
                "touristType='" + touristType + '\'' +
                '}';
    }
}
