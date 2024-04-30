package People;

public class Admin extends Person {
    public Admin(String name, String lastName, String FieldOfStudy, String ID, String phoneNumber,
    String email, String UserName, String Password) {
        super(name, lastName, FieldOfStudy, ID, phoneNumber,
        email, UserName, Password);
    }

    @Override
    public boolean isIDValid(String ID) {
        return true;
    }
}
