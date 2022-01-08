package part2.task3;

import org.dom4j.DocumentException;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class Bouquet {
    public abstract List<Flower> getFlowerList() throws FileNotFoundException, DocumentException;
}
