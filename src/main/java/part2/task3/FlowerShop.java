package part2.task3;

import org.dom4j.DocumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class FlowerShop {
    public static void main(String[] args) throws IOException, DocumentException {
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
        writeBouquetPrice(totalPrice);
        System.out.println("The price of this bouquet is:  "+ totalPrice );
    }

    private static void writeBouquetPrice(int totalPrice) throws IOException {
        try {
            FileWriter flowerPrice = new FileWriter("c:\\data\\EPAM\\bouquetPrice.txt");
            flowerPrice.write(totalPrice);
            flowerPrice.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getTotalPrice( Bouquet bouquet) throws FileNotFoundException, DocumentException {
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