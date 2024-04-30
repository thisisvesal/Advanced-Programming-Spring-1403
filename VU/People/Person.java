package People;

import Frames.LoginPage;
import Frames.SignupPage;

import javax.swing.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {
    private static ArrayList<Person> people = new ArrayList<>();
    String name, lastName, FieldOfStudy, UserName, Password, phoneNumber, email, ID;
    public static int personCounter;
    static Person currentUser;
    public final ArrayList<JCheckBox> taskBoxes = new ArrayList<>();
    public final ArrayList<JButton> classList = new ArrayList<>();

    public Person(String name, String lastName, String FieldOfStudy, String ID, String phoneNumber,
            String email, String UserName, String Password) {
        if (!isInputValid(name)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid name!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isInputValid(lastName)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid last name!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isInputValid(FieldOfStudy)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid Field of Study!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isIDValid(ID)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid ID !", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isPhoneNumberValid(phoneNumber)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid phone number!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isEmailValid(email)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid email!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isUserNameValid(UserName)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid username!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!isPasswordValid(Password)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Invalid password!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!UniqueID(ID)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "This educational ID already exits!",
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" },
                    "OK");
            return;
        } else if (!UniqueEmail(email)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Such email already exits!", "Warning",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        } else if (!UniqueUserName(UserName)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Such UserName already exits!",
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" },
                    "OK");
            return;
        } else if (!UniquePhoneNumber(phoneNumber)) {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "Such PhoneNumber already exits!",
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" },
                    "OK");
            return;
        }

        this.name = name;
        this.lastName = lastName;
        this.FieldOfStudy = FieldOfStudy;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.UserName = UserName;
        this.Password = Password;
        people.add(this);
        currentUser = this;
        personCounter++;
        SignupPage.signupSuccessful = true;
    }

    public static boolean personExists(String UserName, String password) {
        for (Person person : people) {
            if (person.Password.equals(password) && person.UserName.equals(UserName)) {
                return true;
            }
            // THIS WILL NEVER BE SATISFIED
            // else if (!person.Password.equals(password) && person.ID.equals(ID)) {
            //     LoginPage.ForgetPass = true;
            //     return false;
            // }
        }
        JOptionPane.showOptionDialog(LoginPage.getInstance(), "No such user found!", "Warning",
                JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");

        return false;
    }

    public static Person findPerson(String UserName, String password) {
        for (Person person : people) {
            if (person.Password.equals(password) && person.UserName.equals(UserName)) {
                return person;
            }
        }
        return null;
    }

    public boolean UniqueID(String ID) {
        for (Person person : people) {
            if (person.ID.equals(ID))
                return false;
        }
        return true;
    }

    public boolean UniqueEmail(String email) {
        for (Person person : people) {
            if (person.email.equals(email))
                return false;
        }
        return true;
    }

    public boolean UniqueUserName(String UserName) {
        for (Person person : people) {
            if (person.UserName.equals(UserName))
                return false;
        }
        return true;
    }

    public boolean UniquePhoneNumber(String phoneNumber) {
        for (Person person : people) {
            if (person.phoneNumber.equals(phoneNumber))
                return false;
        }
        return true;
    }

    protected boolean isUserNameValid(String UserName) {
        String regex = "^[a-zA-Z0-9]{5,12}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(UserName);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

    protected boolean isPasswordValid(String pass) {
        String regex = "^[a-zA-Z0-9]{8,12}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(pass);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

    protected boolean isInputValid(String string) {
        String regex = "^[a-zA-Z]{1,18}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(string);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

    protected boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9.]{1,18}@[a-z0-9.]{1,8}(.)[a-z]{1,4}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(email);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

    public abstract boolean isIDValid(String ID);

    protected boolean isPhoneNumberValid(String phone) {
        String regex = "^09[0-9]{9}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(phone);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public static Person getCurrentUser() {
        // Actual code:
        return currentUser;

        // Sample:
        // return new Student("Strawberry", "Shortcake", "Collinary", "4021262437", "09021234567", "strawberry@sck.com",
        //        "username", "passwordddd");
    }
    
    public static void setCurrentUser(Person currentUser) {
        Person.currentUser = currentUser;
    }

    public String getID() {
        return ID;
    }

    public static void addPerson(Person person) {
        people.add(person);
    }
}
