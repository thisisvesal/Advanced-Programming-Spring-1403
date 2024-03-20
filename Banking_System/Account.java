public class Account {
    private String accountNumber;
    private int balance;
    private Customer accountOwner;
    private Branch branch;

    public Account(Customer accountOwner, Branch branch) {
        this.accountOwner = accountOwner;
        this.branch = branch;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(int balace) {
        this.balance = balace;
    }
    public int getBalance() {
        return balance;
    }

    public void setAccountOwner(Customer accountOwner) {
        this.accountOwner = accountOwner;
    }
    public Customer getAccountOwner() {
        return accountOwner;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
    public Branch getBranch() {
        return branch;
    }

}
