// See this project in my github repo:
// https://github.com/thisisvesal/Advanced-Programming-Spring-1403/tree/master/Banking_System

public class Main {
    public static void main(String[] args) {
        Bank catlar = new Bank("Catlar", "Kitty");

        catlar.branchGenerator("kethan", "kittyland");
        Branch kethan = catlar.getBranchAt(0);
        kethan.codeGenerator(12);

        Customer kitty = catlar.getBranchAt(0).customerGenerator("cotton", "kitty", "83", "123");
        kethan.accountGenerator(kitty);

        Customer goorba = catlar.getBranchAt(0).customerGenerator("Goorba", "Gorbachev", "73", "1462");
        kethan.accountGenerator(goorba);
        Account kittysAccount = kitty.getAccount();

        Account gorbAccount = goorba.getAccount();

        catlar.getInfo();

        kittysAccount.deposit(20);

        int kittysbalance = kittysAccount.getBalance();

        System.out.println(kitty.getLastName() + "'s balance is: " + kittysbalance);

        System.out.println("Goorba's account number is " + gorbAccount.accountNumber);

    }
}
