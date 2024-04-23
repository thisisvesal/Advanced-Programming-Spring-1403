package Employee;
public abstract class Employee {
    // The access modifier for the following attributes is set to default so they can only be accessed within the same package
    String name;
    double salary;
    int age;
    int yearsOfService;

    Employee(String name, double salary, int age, int yearsOfService) {
        this.name = name;
        setSalary(salary);
        setAge(age);
        setYearsOfService(yearsOfService);
    }

    public double calculatePay() {
        return salary;
    }
    
    public abstract boolean isElligibleForBonus();

    public void printInfo() {
        System.out.println("Employee info:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Base salary: " + salary);
        System.out.println("Years of service: " + yearsOfService);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Invalid salary amount");
            return;
        }
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Invalid age");
            return;
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService < 0) {
            System.out.println("Invalid years of service");
            return;
        }
        this.yearsOfService = yearsOfService;
    }
    public int getYearsOfService() {
        return yearsOfService;
    }
}