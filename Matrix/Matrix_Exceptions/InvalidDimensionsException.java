package Matrix_Exceptions;
public class InvalidDimensionsException extends RuntimeException {
    public InvalidDimensionsException(String message) {
        super(message);
    }

    public InvalidDimensionsException() {
        super("Invalid Dimensions");
    }
}
