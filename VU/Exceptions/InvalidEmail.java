package Exceptions;

public class InvalidEmail extends RuntimeException{
    public InvalidEmail(){
        super("Invalid Email");
    }
}
