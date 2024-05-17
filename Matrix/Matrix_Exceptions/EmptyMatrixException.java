package Matrix_Exceptions;
public class EmptyMatrixException extends RuntimeException {
    public EmptyMatrixException(String message) {
        super(message);
    }

    public EmptyMatrixException() {
        super("Empty matrix exception");
    }
}
