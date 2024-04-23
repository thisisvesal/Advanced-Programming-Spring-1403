package People;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    protected boolean isEmailValid (String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+.-]+(.)[a-zA-Z0-9+.-]$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(email);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }
}