package Employee;

public class OvertimeHourlyEmployee extends HourlyEmployee {
    int overtimeHours;

    @Override
    public double calculatePay() {
        return super.calculatePay() + (overtimeHours * 50000);
    }
}
