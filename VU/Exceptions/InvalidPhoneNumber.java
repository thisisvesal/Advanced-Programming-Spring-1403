package Exceptions;

public class InvalidPhoneNumber extends RuntimeException{
    public InvalidPhoneNumber(){
        super("Invalid PhoneNumber");
    }
}
