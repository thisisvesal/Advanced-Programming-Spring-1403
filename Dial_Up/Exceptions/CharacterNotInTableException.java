package Exceptions;
public class CharacterNotInTableException extends RuntimeException {
    public CharacterNotInTableException(String message) {
        super(message);
    }
    public CharacterNotInTableException() {
        super("Character not found in the defined set");
    }
}
