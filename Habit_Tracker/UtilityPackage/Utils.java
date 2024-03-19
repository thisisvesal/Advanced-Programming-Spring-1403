package UtilityPackage;

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
}
