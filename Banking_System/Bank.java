import java.util.Scanner;

public class Bank {
    private String name;
    private String codeOfBank;
    private int number;
    private String bankCEO;
    private static int countOfBanks;
    private int countOfCustomers;
    private int countOfBranches;
    private Branch[] branches = new Branch[100];

    public Bank(String name, String bankCEO) {
        countOfBanks++;
        this.name = name;
        this.bankCEO = bankCEO;
    }

    public Branch branchGenerator(String managerName, String address) {
        branches[countOfBranches] = new Branch(managerName, address, this);
        countOfBranches++;
        return branches[countOfBranches - 1];
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

    public static int getCountOfBanks() {
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

    public void addCustomerCount() {
        countOfCustomers++;
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

    public Branch getBranchAt(int i) {
        return branches[i];
    }

    public void printAllBranches() {
        for(int i = 0; i < countOfBranches; i++) {
            System.out.println(branches[i].getManagerName());
        }
    }


    public void getInfo() {
        System.out.println("Bank info:");
        System.out.println("name: " + name);
        System.out.println("code of bank: " + codeOfBank);
        System.out.println("number: " + number);
        System.out.println("CEO: " + bankCEO);
        System.out.println("CountOfBanks: " + countOfBanks);
        System.out.println("Count of customers: " + countOfCustomers);
        System.out.println("Count of branches: " + countOfBanks);
        System.out.println("Branches: ");
        printAllBranches();
    }
}