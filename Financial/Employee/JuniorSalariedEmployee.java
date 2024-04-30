package Employee;

public class JuniorSalariedEmployee extends SalariedEmployee {
    public JuniorSalariedEmployee(String name, int salary, int age, int yearsOfService, int bonus) {
        super(name, salary, age, yearsOfService, bonus);
    }
    
    @Override
    public double calculatePay() {
        int extraYearsOfService = 0;
        if (yearsOfService > 5) {
            extraYearsOfService = yearsOfService - 5;
        }
        return super.calculatePay() + (extraYearsOfService * 200000);
    }
}
