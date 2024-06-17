package People;

import Exceptions.*;
import Frames.LoginPage;
import Frames.SignupPage;
import Questions.Course;
import Questions.Home;

import javax.swing.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person implements Serializable {
    public static ArrayList<Person> people = new ArrayList<>();
    String name, lastName, FieldOfStudy, UserName, Password, phoneNumber, email, ID;
    public static int personCounter;
    static Person currentUser;
    public final ArrayList<JCheckBox> taskBoxes = new ArrayList<>();
    public final ArrayList<JButton> classList = new ArrayList<>();


    private Home home;

    public Person(String name, String lastName, String FieldOfStudy, String ID, String phoneNumber,
                  String email, String UserName, String Password) {

        String Invalid="";
        try {
            Invalid="Invalid name!";
            isInputValid(name);
            Invalid="Invalid lastName!";
            isInputValid(lastName);
            Invalid="Invalid FieldOfStudy!";
            isInputValid(FieldOfStudy);
        }catch (InvalidInput e){
            JOptionPane.showOptionDialog(LoginPage.getInstance(), Invalid,
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        }
        try {
            JOptionPane.showOptionDialog(LoginPage.getInstance(), "ID Processed",
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            isIDValid(ID);
        }catch (InvalidIDException e){
            JOptionPane.showOptionDialog(LoginPage.getInstance(), e.getMessage(),
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        }
        try {
            isPhoneNumberValid(phoneNumber);
        } catch (InvalidPhoneNumber e){
            JOptionPane.showOptionDialog(LoginPage.getInstance(), e.getMessage(),
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        }
        try {
            isEmailValid(email);
        }catch (InvalidEmail e){
            JOptionPane.showOptionDialog(LoginPage.getInstance(), e.getMessage(),
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        }
        try {
            isUserNameValid(UserName);
        }catch (InvalidUsername e){
            JOptionPane.showOptionDialog(LoginPage.getInstance(), e.getMessage(),
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        }
        try {
            isPasswordValid(Password);
        }catch (InvalidPassword e){
            JOptionPane.showOptionDialog(LoginPage.getInstance(), e.getMessage(),
                    "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
            return;
        }
        if (!UniqueID(ID)) {
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
                   "Warning", JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");
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
        }
        JOptionPane.showOptionDialog(LoginPage.getInstance(), "No such user found!", "Warning",
                JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] { "OK" }, "OK");

        return false;
    }

    public static Person findPerson(String UserName, String password) throws Exception{
        if(people == null) throw new Exception();
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

    protected boolean isUserNameValid(String UserName) throws InvalidUsername {
        String regex = "^[a-zA-Z0-9]{1,12}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(UserName);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        throw new InvalidUsername();
    }

    protected boolean isPasswordValid(String pass) throws InvalidPassword {
        String regex = "^[a-zA-Z0-9]{1,12}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(pass);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        throw new InvalidPassword();
    }

    protected boolean isInputValid(String string) throws InvalidInput {
        String regex = "^[a-zA-Z]{1,18}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(string);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
       throw new InvalidInput();
    }

    protected boolean isEmailValid(String email) throws InvalidEmail {
        String regex = "^[a-zA-Z0-9.]{1,18}@[a-z0-9.]{1,8}(.)[a-z]{1,4}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(email);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        throw new InvalidEmail();
    }

    public abstract boolean isIDValid(String ID) throws InvalidIDException;

    protected boolean isPhoneNumberValid(String phone) throws InvalidPhoneNumber {
        String regex = "^09[0-9]{9}$";
        Pattern patten = Pattern.compile(regex);
        Matcher matcher = patten.matcher(phone);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        throw new InvalidPhoneNumber();
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public static Person getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Person currentUser) {
        Person.currentUser = currentUser;
    }

    public String getID() {
        return ID;
    }

   /* public static void addPerson(Person person) {
        people.add(person);
    }*/

    public void setHome(Home home) {
        this.home = home;
    }

    public Home getHome() {
        return home;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // out.writeObject(this.Password);  // Custom serialization for password
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // this.password = decryptPassword((String) in.readObject());  // Custom deserialization for password
    }
}