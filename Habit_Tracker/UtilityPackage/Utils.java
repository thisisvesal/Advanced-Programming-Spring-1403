package UtilityPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isPasswordValid(String password) {
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (int i = 0; i < password.length() && !(hasLetter && hasNumber); i++) {
            if ('0' <= password.charAt(i) && password.charAt(i) <= '9') {
                hasNumber = true;
            }
            else if ('a' <= password.charAt(i) && password.charAt(i) <= 'z') {
                hasLetter = true;
            }
            else if ('A' <= password.charAt(i) && password.charAt(i) <= 'Z') {
                hasLetter = true;
            }
        }

        return (hasLetter && hasNumber);
    }

    public static boolean isLowerCase(char x) {
        if ('a' <= x && x <= 'z') {
            return true;
        }
        return false;
    }

    public static boolean isUpperCase(char x) {
        if ('A' <= x && x <= 'Z') {
            return true;
        }
        return false;
    }

    public static boolean isEmailValid (String email) {
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
