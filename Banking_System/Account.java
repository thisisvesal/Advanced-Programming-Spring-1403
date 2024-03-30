import java.util.Random;

public class Account {
    public final String accountNumber;
    private int balance;
    public final Customer accountOwner;
    private Branch branch;

    public Account(Customer accountOwner, Branch branch) {
        Random random = new Random();
        this.accountOwner = accountOwner;
        this.branch = branch;
        accountOwner.setAccount(this);

        String personsCode;
        if (accountOwner.IDInCentralBanking < 10) {
            personsCode = "000" + accountOwner.IDInCentralBanking;
        } else if (accountOwner.IDInCentralBanking < 100) {
            personsCode = "00" + accountOwner.IDInCentralBanking;
        } else if (accountOwner.IDInCentralBanking < 1000) {
            personsCode = "0" + accountOwner.IDInCentralBanking;
        } else {
            personsCode = "" + accountOwner.IDInCentralBanking;
        }

        accountNumber = branch.bank.getCodeOfBank() + branch.getCode() + personsCode
                + (random.nextInt(9999 - 1000 + 1) + 1000);
    }

    public void deposit(int amount) {
        if (amount >= 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount cannot be negative");
        }
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Withdrawal amount cannot be negative");
        } else if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("The customer does not have enough balance for this withdrawal");
        }
    }

    // There is no setBalance method. Use deposit and withdraw instead.
    
    public int getBalance() {
        return balance;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
        branch.accountGenerator(accountOwner);
    }

    public Branch getBranch() {
        return branch;
    }

}
