package Matrix_Exceptions;
public class DetIsZeroException extends RuntimeException {
    public DetIsZeroException(String message) {
        super(message);
    }

    public DetIsZeroException() {
        super("The determinant is zero");
    }
}
