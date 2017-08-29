package model.entity;

public class Food {
    private String firstCourse;
    private String secondCourse;
    private String dessert;
    private String drink;

    public Food(String firstCourse, String secondCourse, String dessert, String drink) {
        this.firstCourse = firstCourse;
        this.secondCourse = secondCourse;
        this.dessert = dessert;
        this.drink = drink;
    }

    public String getFirstCourse() {
        return firstCourse;
    }

    public void setFirstCourse(String firstCourse) {
        this.firstCourse = firstCourse;
    }

    public String getSecondCourse() {
        return secondCourse;
    }

    public void setSecondCourse(String secondCourse) {
        this.secondCourse = secondCourse;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        if (getFirstCourse() != null ? !getFirstCourse().equals(food.getFirstCourse()) : food.getFirstCourse() != null)
            return false;
        if (getSecondCourse() != null ? !getSecondCourse().equals(food.getSecondCourse()) : food.getSecondCourse() != null)
            return false;
        if (getDessert() != null ? !getDessert().equals(food.getDessert()) : food.getDessert() != null) return false;
        return getDrink() != null ? getDrink().equals(food.getDrink()) : food.getDrink() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstCourse() != null ? getFirstCourse().hashCode() : 0;
        result = 31 * result + (getSecondCourse() != null ? getSecondCourse().hashCode() : 0);
        result = 31 * result + (getDessert() != null ? getDessert().hashCode() : 0);
        result = 31 * result + (getDrink() != null ? getDrink().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
                "firstCourse='" + firstCourse + '\'' +
                ", secondCourse='" + secondCourse + '\'' +
                ", dessert='" + dessert + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}
