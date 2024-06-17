package Exceptions;

public class InvalidIDException extends RuntimeException {
    public InvalidIDException(){
        super("Invalid ID");
    }

}
