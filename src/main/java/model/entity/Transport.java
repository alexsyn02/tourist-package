package model.entity;

/**
 * Created by Alexandr on 10.08.2017.
 */
public class Transport {

    private String type;

    public Transport(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        return getType() != null ? getType().equals(transport.getType()) : transport.getType() == null;
    }

    @Override
    public int hashCode() {
        return getType() != null ? getType().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "type='" + type + '\'' +
                '}';
    }
}
