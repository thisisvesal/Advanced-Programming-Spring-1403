package Exceptions;

public class InvalidPassword extends RuntimeException{
    public InvalidPassword(){
        super("Invalid Password");
    }
}
