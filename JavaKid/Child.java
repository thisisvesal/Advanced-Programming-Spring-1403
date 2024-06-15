class Child {
    private double money;
    private double cost;

    public Child(double money, double cost) {
        this.money = money;
        this.cost = cost;
    }

    public synchronized void buy() {
        System.out.println("Buy method is run");
        if (money >= cost) {
            System.out.println("Money is more than price. Toy bought!");
            money -= cost;
        } else {
            try {
                System.out.println("Money is not enough, buy thread is going to wait...");
                wait();
                System.out.println("Buy thread is awake");
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addMoney(double amount) {
        money += amount;
        System.out.println("Added " + amount + " worth of money, new total: " + money);
        System.out.println("Notifying all threads");
        notifyAll();
    }

    public synchronized void newWish(double newCost) {
        cost = newCost;
        System.out.println("New toy cost set to " + newCost);
    }

    public double getMoney() {
        return money;
    }
}
