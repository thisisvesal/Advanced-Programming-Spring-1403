package Employee;

public class RegularHourlyEmployee extends HourlyEmployee {
    
    @Override
    public boolean isElligibleForBonus() {
        return true;
    }
}
