package part2.task3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BouquetSetC extends Bouquet {
    public List<Flower> getFlowerList() throws DocumentException {
        List<Flower> flowers = new ArrayList();
        // TODO Auto-generated method stub
        //1.创建SAXReader对象用于读取xml文件
        SAXReader reader = new SAXReader();
        //2.读取xml文件，获得Document对象
        Document doc = reader.read(new File("src/book.xml"));
        //3.获取根元素
        Element root = doc.getRootElement();
        //4.获取根元素下的所有子元素（通过迭代器）
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()){

            Element e = it.next();
            //获取id属性(attribute是属性的意思)
            Attribute id = e.attribute("id");
            System.out.println(id.getName()+" = "+id.getStringValue());
            Element flowerName = e.element("name");
            Element flowerPrice = e.element("price");
            Element flowerColor = e.element("color");
            if ("Rose".equalsIgnoreCase(flowerName.getStringValue())) {
                flowers.add(new Rose(flowerColor.getText(), (Integer) flowerPrice.getData()));
            } else if ("Lily".equalsIgnoreCase(flowerName.getStringValue())) {
                flowers.add(new Lily(flowerColor.getText(), (Integer) flowerPrice.getData()));
            }
        }
        return flowers;
    }
}
