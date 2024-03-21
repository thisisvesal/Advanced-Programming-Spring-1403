public class Account {
    private String accountNumber;
    private int balance;
    public final Customer accountOwner;
    private Branch branch;

    public Account(Customer accountOwner, Branch branch) {
        this.accountOwner = accountOwner;
        this.branch = branch;
        accountOwner.setAccount(this);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
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
