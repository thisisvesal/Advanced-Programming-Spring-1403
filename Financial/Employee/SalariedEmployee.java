package Employee;

public class SalariedEmployee extends Employee {
    private double bonus;

    public SalariedEmployee(String name, int salary, int age, int yearsOfService, int bonus) {
        super(name, salary, age, yearsOfService);
        setBonus(bonus);
    }

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
        System.out.println("Elligibillity for bonus: " + isElligibleForBonus());
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            System.out.println("Invalid bonus value");
            return;
        }
        this.bonus = bonus;
    }
}
