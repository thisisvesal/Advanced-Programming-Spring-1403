import java.util.Scanner;

public class Branch {
    private String managerName;
    private String address;
    private String code;
    private Bank bank;
    private int customerCount;
    private int number;

    public Branch(String managerName, String address, Bank bank) {
        this.managerName = managerName;
        this.address = address;
        this.bank = bank;
    }

    public Customer customerGenerator(String name, String lastName, String phoneNumber, String nationalCode, String email) {
        return new Customer(name, lastName, phoneNumber, nationalCode, email);
    }
    public Customer customerGenerator(String name, String lastName, String phoneNumber, String nationalCode) {
        return customerGenerator(name, lastName, phoneNumber, nationalCode);
    }

    public Account accountGenerator(Customer customer) {
        return new Account(customer, this);
    }

    public String codeGenerator(String number) {
        code = "6010" + number;
        return code;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getManagerName() {
        return managerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Bank getBank() {
        return bank;
    }

    public void setCustomerCount(int customerCount) {
        if (customerCount >= 0) {
            this.customerCount = customerCount;
        } else {
            System.out.println("The number of customers cannot be negative!");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter again: ");
            setCustomerCount(scanner.nextInt());
            scanner.close();
        }
    }
    public int getCustomerCount() {
        return customerCount;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
        else {
            System.out.println("Branch number should be at least 1");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter again: ");
            setNumber(scanner.nextInt());
            scanner.close();
        }
        
    }
    public int getNumber() {
        return number;
    }
}
