package part2.task1;

import java.util.ArrayList;
import java.util.List;

public class BouquetSetB extends Bouquet {
    public List<Flower> getFlowerList() {
        List <Flower> flowers = new ArrayList();
        Flower rose = new Rose("Rose","红",10);
        Flower lily = new Lily("Lily","白",15);
        // flowers.add those rose and lily
        flowers.add(rose);
        flowers.add(lily);
        return flowers;
    }
}
