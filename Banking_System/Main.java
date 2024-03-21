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

        Account kittysAccount = kitty.getAccount();

        catlar.getInfo();

        kittysAccount.deposit(20);

        int kittysbalance = kittysAccount.getBalance();

        System.out.println(kitty.getLastName() + "'s balance is: " + kittysbalance);

    }
}
