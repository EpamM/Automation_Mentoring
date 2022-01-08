package part2.task1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Bouquet {
    public abstract List<Flower> getFlowerList() throws FileNotFoundException;
}
