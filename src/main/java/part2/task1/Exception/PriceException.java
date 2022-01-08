package part2.task1.Exception;


/*
定义一个价格限制范围的自定义异常
 */
public class PriceException extends RuntimeException{
    public PriceException(String message){
        super(message);
    }
}
