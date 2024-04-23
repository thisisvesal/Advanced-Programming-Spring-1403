package Employee;

public class SalariedEmployee extends Employee {
    private double bonus;

    @Override
    public double calculatePay() {
        return super.calculatePay() + (yearsOfService * 500000);
    }

    @Override
    public boolean isElligibleForBonus() {
        if (yearsOfService > 5) {
            return true;
        }
        return false;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Bonus: " + bonus);
        System.out.println("Final pay: " + calculatePay());
        System.out.println("Elligibillity for bonuses: " + isElligibleForBonus());
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
