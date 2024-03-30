public class Customer {
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private static int count; // This attribute cannot be accessed from outside of the class, since it's only meant to determine IDInCentralBanking
    public final int IDInCentralBanking;
    private String nationalCode;
    private Account account;

    public Customer(String name, String lastName, String phoneNumber, String nationalCode, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.email = email;
        count++;
        IDInCentralBanking = count;
    }

    public Customer(String name, String lastName, String phoneNumber, String nationalCode) {
        this(name, lastName, phoneNumber, nationalCode, "def@mail.com");
    }

    public void deposit(int amount) {
        this.account.deposit(amount);
    }

    public void withdraw(int amount) {
        this.account.withdraw(amount);
    }

    public int getBalance() {
        return this.account.getBalance();
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

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
