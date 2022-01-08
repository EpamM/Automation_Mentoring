package part2.task3;

import part2.task3.Exception.BouquetTooLargeException;
import part2.task3.Exception.FlowerNotFoundException;
import part2.task3.Exception.PriceException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BouquetSetA extends Bouquet {

    @Override
    public List<Flower> getFlowerList() throws FileNotFoundException {

        String[] flowerArray = new String[100];
        File flowerFile = new File("c:\\data\\EPAM\\test.txt");
        List<Flower> flowers = new ArrayList();
        try {
            Scanner myReader = new Scanner(flowerFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                flowerArray = data.split(",");

                if ("Rose".equalsIgnoreCase(flowerArray[0])) {
                    flowers.add(new Rose(flowerArray[1], Integer.parseInt(flowerArray[2])));
                } else if ("Lily".equalsIgnoreCase(flowerArray[0])) {
                    flowers.add(new Lily(flowerArray[1], Integer.parseInt(flowerArray[2])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        // get NullPointerException when 调用空对象的方法
        try {
            Rose rose = null;
            rose.getColor();
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // get PriceException when 价格低于指定值
        verifyFlowerPrice(flowers);

        //  get FlowerNotFoundException when 花束里混入了定义外的花
        String[] allFlowerNames = new String[]{"Rose1", "Lily", "Alstroemerias", "California Poppy", "Orchids"};
        List<String> flowersNameList = new ArrayList<>(Arrays.asList(allFlowerNames));
        try {
            for (Flower flower : flowers) {
                if (!flowersNameList.contains(flower.getName())) {
                    throw new FlowerNotFoundException(flower.getName() + "花拿错了！");
                }
            }
        } catch (FlowerNotFoundException e) {
            System.out.println(e);
        }

        //  get StringIndexOutOfBoundsException when 尝试访问字符串的下标大于其长度的字符
        try {
            flowers.get(0).getColor().charAt(5);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // get NumberFormatException when 参数不能转成数字
        try {
            int i = Integer.parseInt(flowers.get(0).getName());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }


        try {
            if (flowers.size() > 1) {
                throw new BouquetTooLargeException("花束太多，需要换包装了！");
            }
        } catch (BouquetTooLargeException e) {
            System.out.println(e);
        }
        return flowers;
    }

    private void verifyFlowerPrice(List<Flower> flowers) {
        try {
            for (Flower flower : flowers) {
                if (flower.getPrice() < 15) {
                    throw new PriceException("价格出错！");
                }
            }
        } catch (PriceException e) {
            System.out.println(e);
        }
    }
}
