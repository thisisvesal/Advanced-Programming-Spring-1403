package People;

import Frames.HomePage;
import Frames.LoginPage;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Professor extends Person {
    public Professor(String name, String lastName, String FieldOfStudy, String ID, String phoneNumber, String email,
            String UserName, String Password) {
        super(name, lastName, FieldOfStudy, ID, phoneNumber, email, UserName, Password);
    }

    @Override
    public boolean isIDValid(String ID) {
        String regex = "^[0-9]{6}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(ID);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }

        JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid ID ", "Warning", JOptionPane.WARNING_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + name + " lastName: " + lastName + " ID: " + ID;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Professor)
            return true;
        else
            return false;
    }

    public void editClassInfo() {
        JOptionPane.showOptionDialog(HomePage.getInstance(), "Edit this class info", "Confirm",
                JOptionPane.WARNING_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");

        JOptionPane.showOptionDialog(HomePage.getInstance(), "Edited successfully", "Success",
                JOptionPane.WARNING_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
    }

}
