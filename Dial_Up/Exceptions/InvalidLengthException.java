package Exceptions;
public class InvalidLengthException extends RuntimeException {
    public InvalidLengthException(String message) {
        super(message);
    }
    public InvalidLengthException() {
        super("Invalid length");
    }
}
