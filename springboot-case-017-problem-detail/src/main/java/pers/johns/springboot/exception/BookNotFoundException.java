package pers.johns.springboot.exception;

/**
 * ClassName    : BookNotFoundException
 * Description  :
 * CreateTime   : 2024/6/8 15:07
 *
 * @author : JohnS
 * @version : 1.0
 */

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
