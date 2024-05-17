package Matrix_Exceptions;
public class NotSquaredException extends RuntimeException {
    public NotSquaredException(String message) {
        super(message);
    }

    public NotSquaredException() {
        super("Your matrix is not squared");
    }
}
