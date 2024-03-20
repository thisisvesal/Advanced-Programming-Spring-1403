import java.util.Scanner;

public class Customer {
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private int IDInCentralBanking;
    private String nationalCode;
    private Account account;

    public Customer(String name, String lastName, String phoneNumber, String nationalCode, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.email = email;
    }

    public Customer(String name, String lastName, String phoneNumber, String nationalCode) {
        new Customer(name, lastName, phoneNumber, nationalCode, "def@mail.com");
    }

    public void deposit(int amount) {
        this.account.setBalance(this.account.getBalance() + amount);
    }

    public void withdraw(int amount) {
        if (amount <= this.account.getBalance()) {
            this.account.setBalance(this.account.getBalance() - amount);
        } else {
            System.out.println("The customer does not have enough balance for this withdrawal");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIDInCentralBanking(int IDInCentralBanking) {
        if (IDInCentralBanking > 0) {
            this.IDInCentralBanking = IDInCentralBanking;
        } else {
            System.out.println("The customer's ID should be at least 1!");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter again: ");
            setIDInCentralBanking(scanner.nextInt());
            scanner.close();
        }
    }

    public int getIDInCentralBanking() {
        return IDInCentralBanking;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }
}
