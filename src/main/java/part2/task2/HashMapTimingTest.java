package part2.task2;

import java.util.HashMap;
import java.util.Map;

public class HashMapTimingTest {
    public static void main(String[] args) {
        Map<String,String> M = new HashMap<String,String>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            M.put(Integer.toString(i), "foo");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
