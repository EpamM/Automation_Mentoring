package part2.task1;

import part2.task1.Exception.BouquetTooLargeException;
import part2.task1.Exception.FlowerNotFoundException;
import part2.task1.Exception.PriceException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BouquetSetA extends Bouquet{

    @Override
    public List<Flower> getFlowerList() throws FileNotFoundException {

        String[] flowerArray = new String[100];
        File flowerFile=new File("c:\\data\\EPAM\\test.txt");
        if(flowerFile.exists()){
            System.out.println("File name: " +flowerFile.getName());
        }
        try {
            Scanner myReader = new Scanner(flowerFile);
            while (myReader.hasNextLine()){
                String data= myReader.nextLine();
                flowerArray = data.split(",");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        List <Flower> flowers = new ArrayList();

        // get NullPointerException when 调用空对象的方法
        try {
            Rose rose = null;
            rose.getColor();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        Flower rose = new Rose(flowerArray[1],"红",10);
        Flower lily = new Lily("Lily","白",15);

        // get PriceException when 价格低于指定值
        try {
            if (rose.getPrice() <15) {
                throw new PriceException("价格出错！");
            }
        } catch (PriceException e) {
            System.out.println(e);
        }
        //  get FlowerNotFoundException when 花束里混入了定义外的花
        String[] flowersNameArray = new String[]{"Rose1", "Lily", "Alstroemerias", "California Poppy", "Orchids"};
        List<String> flowersNameList = new ArrayList<>(Arrays.asList(flowersNameArray));
        try {
            if(! flowersNameList.contains(rose.getName())){
                throw new FlowerNotFoundException("花拿错了！");
            }
        } catch (FlowerNotFoundException e) {
            System.out.println(e);
        }

        //  get StringIndexOutOfBoundsException when 尝试访问字符串的下标大于其长度的字符
        try {
            rose.getColor().charAt(5);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }

         // get NumberFormatException when 参数不能转成数字
        try {
            int i  = Integer.parseInt(rose.getName());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        // flowers.add those rose and lily
        for(int i=0;i<2;i++){
            flowers.add(rose);
        }
        for(int j=0;j<3;j++){
            flowers.add(lily);
        }

        try {
            if(flowers.size()>1){
                throw new BouquetTooLargeException("花束太多，需要换包装了！");
            }
        } catch (BouquetTooLargeException e) {
            System.out.println(e);
        }
        return flowers;
    }
}
