import Employee.Employee;
import Employee.RegularHourlyEmployee;
import Employee.OvertimeHourlyEmployee;
import Employee.CommissionedEmployee;
import Employee.JuniorSalariedEmployee;
import Employee.SeniorSalariedEmployee;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];

        
        employees[0] = new RegularHourlyEmployee("Apatosauras", 50000, 10, 1, 8, 50000);
        
        employees[1] = new OvertimeHourlyEmployee("Spinosaurus", 40000, 4, 2, 3, 7, 40000);

        employees[2] = new CommissionedEmployee("Carnotauras", 100000, 12, 7, 100000, 10);

        employees[3] = new JuniorSalariedEmployee("Troodon", 30000, 3, 0, 0);

        employees[4] = new SeniorSalariedEmployee("T-Rex", 150000, 15, 10, 4);

        employees[5] = new CommissionedEmployee("Archaeopteryx", 100000, 10, 8, 500000, 10);

        for (Employee employee : employees) {
            employee.printInfo();
        }
    }
}
