package Matrix_Exceptions;
public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(String message) {
        super(message);
    }

    public OutOfRangeException() {
        super("Out of range");
    }
}
