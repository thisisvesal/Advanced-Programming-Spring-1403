package Employee;

public class RegularHourlyEmployee extends HourlyEmployee {
    public RegularHourlyEmployee(String name, int salary, int age, int yearsOfService, double hours, double hourlyRate) {
        super(name, salary, age, yearsOfService, hours, hourlyRate);
    }
    
    @Override
    public boolean isElligibleForBonus() {
        return true;
    }
}
