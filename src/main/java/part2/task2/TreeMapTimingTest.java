package part2.task2;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTimingTest {
    public static void main(String[] args) {
        Map<String,String> T = new TreeMap<String,String>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            T.put(Integer.toString(i), "foo");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
