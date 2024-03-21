public class Main {
    public static void main(String[] args) {
        Bank catlar = new Bank("Catlar", "Kitty");
        catlar.branchGenerator("kethan", "kittyland");

        Customer kitty = catlar.getBranchAt(0).customerGenerator("cotton", "kitty", "83", "123");
        catlar.getInfo();
        Branch kethan = catlar.getBranchAt(0);

        kethan.accountGenerator(kitty);

        kethan.codeGenerator(12);

        kitty.deposit(20);

        int kittysbalance = kitty.getAccount().getBalance();

        System.out.println("kitty's balance is: " + kittysbalance);

        Account kittysAccount = kitty.getAccount();

        System.out.println(kittysAccount.getBranch().getManagerName());

        System.out.println(kitty.getName());

    }
}
