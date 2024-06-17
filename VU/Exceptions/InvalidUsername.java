package Exceptions;

public class InvalidUsername extends RuntimeException{
    public InvalidUsername(){
        super("Invalid Username");
    }
}
