import java.util.Scanner;

public class Bank {
    private String name;
    private String codeOfBank;
    private int number;
    private String bankCEO;
    private static int countOfBanks = 0;
    private int countOfCustomers;
    private int countOfBranches = 0;

    public Bank(String name, String bankCEO) {
        countOfBanks++;
        this.name = name;
        this.bankCEO = bankCEO;
    }

    public Branch branchGenerator(String managerName, String address) {
        countOfBranches++;
        return new Branch(managerName, address, this);
    }

    public String codeGenerator(int number) {
        codeOfBank = "5010" + number;
        return codeOfBank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCodeOfBank(String codeOfBank) {
        this.codeOfBank = codeOfBank;
    }

    public String getCodeOfBank() {
        return codeOfBank;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
        else {
            System.out.println("Bank number should be at least 1");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter again: ");
            setNumber(scanner.nextInt());
            scanner.close();
        }
        
    }

    public int getNumber() {
        return this.number;
    }

    public void setBankCEO(String bankCEO) {
        this.bankCEO = bankCEO;
    }

    public String getBankCEO() {
        return bankCEO;
    }

    public int getCountOfBanks() {
        return countOfBanks;
    }

    public void setCountOfCustomers(int countOfCustomers) {
        if (countOfCustomers >= 0) {
            this.countOfCustomers = countOfCustomers;
        } else {
            System.out.println("The number of customers cannot be negative!");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter again: ");
            setCountOfCustomers(scanner.nextInt());
            scanner.close();
        }

    }

    public int getCountOfCustomers() {
        return countOfCustomers;
    }

    public void setCountOfBranches(int countOfBranches) {
        if (countOfBranches >= 0) {
            this.countOfBranches = countOfBranches;
        } else {
            System.out.println("The number of branches cannot be negative!");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter again: ");
            setCountOfBranches(scanner.nextInt());
            scanner.close();
        }
    }

    public int getCountOfBranches() {
        return countOfBranches;
    }
}