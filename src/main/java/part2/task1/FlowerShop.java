package part2.task1;

import java.io.FileNotFoundException;

class FlowerShop {
    public static void main(String[] args) throws FileNotFoundException {
        int totalPrice= 0;
        Bouquet bouquetSetA = new BouquetSetA();
        Bouquet bouquetSetB = new BouquetSetB();

        // get ClassCastException when 父类引用指向的对象的类型不是子类
        try {
            BouquetSetA BouquetSetA2=(BouquetSetA) bouquetSetB;
        } catch (ClassCastException e) {
            System.out.println(e);
        }

        totalPrice = getTotalPrice(bouquetSetA);
        System.out.println("The price of this bouquet is:  "+ totalPrice );
    }

    private static int getTotalPrice( Bouquet bouquet) throws FileNotFoundException {
        int totalPrice=0;

        // get ArithmeticException when 被除数是0
        try {
            System.out.println( 2/ totalPrice);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        for (Flower flower : bouquet.getFlowerList()) {
            totalPrice = totalPrice + flower.getPrice();
        }
        return totalPrice;
    }
}