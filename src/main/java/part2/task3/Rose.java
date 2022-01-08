package part2.task3;

public class Rose extends Flower {

    private String name = "Rose";
    private String color;
    private int price;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Rose (String color,int price){
        this.color = color;
        this.price = price;
    }
}
