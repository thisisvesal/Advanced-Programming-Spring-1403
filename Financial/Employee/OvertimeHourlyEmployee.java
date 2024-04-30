package Employee;

public class OvertimeHourlyEmployee extends HourlyEmployee {
    int overtimeHours;

    public OvertimeHourlyEmployee(String name, int salary, int age, int yearsOfService, int overtimeHours, double hours, double hourlyRate) {
        super(name, salary, age, yearsOfService, hours, hourlyRate);
        setOvertimeHours(overtimeHours);
    }

    public void setOvertimeHours(int overtimeHours) {
        if (overtimeHours > 0) {
            this.overtimeHours = overtimeHours;
        }
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + (overtimeHours * 50000);
    }
}
