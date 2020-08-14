/**
 * Class Rating is a POJO class for storing the data about one rating of an item
 */

public class Rating implements Comparable<Rating>{

    private String item;
    private double value;

    public Rating(String item, double value) {
        this.item = item;
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "item='" + item + '\'' +
                ", value=" + value +
                '}';
    }

    public int compareTo(Rating other){
        if(value < other.value) return -1;
        if(value > other.value) return 1;

        return 0;
    }
}
