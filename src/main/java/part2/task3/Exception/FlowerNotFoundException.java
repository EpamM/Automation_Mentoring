package part2.task3.Exception;

/*
定义一个鲜花限制种类的自定义异常
 */
public class FlowerNotFoundException extends RuntimeException {
    public FlowerNotFoundException(String message) {
        super(message);
    }
}
