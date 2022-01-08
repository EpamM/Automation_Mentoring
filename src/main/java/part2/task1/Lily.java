package part2.task1;

public class Lily extends Flower {
    private String name;
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

    public Lily (String name,String color,int price){
        this.setName(name);
        this.setColor(color);
        this.setPrice(price);
    }
}
