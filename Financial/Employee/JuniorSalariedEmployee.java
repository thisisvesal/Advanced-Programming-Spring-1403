package Employee;

public class JuniorSalariedEmployee extends SalariedEmployee {
    @Override
    public double calculatePay() {
        int extraYearsOfService = 0;
        if (yearsOfService > 5) {
            extraYearsOfService = yearsOfService - 5;
        }
        return super.calculatePay() + (extraYearsOfService * 200000);
    }
}
