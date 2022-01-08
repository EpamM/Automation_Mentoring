package part2.task3.Exception;

/*
定义一个鲜花数量过多需要换大包装的自定义异常
 */
public class BouquetTooLargeException extends RuntimeException {
    public BouquetTooLargeException(String message) {
        super(message);
    }
}
