package Employee;

public class HourlyEmployee extends Employee {
    double hours;
    double hourlyRate;

    public HourlyEmployee(String name, int salary, int age, int yearsOfService, double hours, double hourlyRate) {
        super(name, salary, age, yearsOfService);
        setHours(hours);
        setHourlyRate(hourlyRate);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + (hourlyRate * hours);
    }

    @Override
    public boolean isElligibleForBonus() {
        return false;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Working hours: " + hours);
        System.out.println("Hourly rate: " + hourlyRate);
        System.out.println("Final pay: " + calculatePay());
        System.out.println("Elligibillity for bonus: " + isElligibleForBonus());
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            System.out.println("Invalid hourly rate");
            return;
        }
        this.hourlyRate = hourlyRate;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHours(double hours) {
        if (hours < 0) {
            System.out.println("Invalid hours");
            return;
        }
        this.hours = hours;
    }
    public double getHours() {
        return hours;
    }
}
