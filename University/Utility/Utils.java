package Utility;

import java.util.Scanner;

public class Utils {
    // This was created as a single utility scanner for the whole program
    // due to the problem with System.in completely closing with every instance of Scanner being closed
    // See this for more info: https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
    public static final Scanner scanner = new Scanner(System.in);
}
