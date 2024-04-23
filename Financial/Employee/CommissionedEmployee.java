package Employee;

public class CommissionedEmployee extends Employee {
    double sales;
    double commissionRate;

    @Override
    public double calculatePay() {
        return sales * commissionRate;
    }

    @Override
    public boolean isElligibleForBonus() {
        if (sales > 100000) {
            return true;
        }
        return false;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Sales: " + sales);
        System.out.println("Comission rate: " + commissionRate);
        System.out.println("Final pay: " + calculatePay());
        System.out.println("Elligibillity for bonus: " + isElligibleForBonus());
    }

    public void setSales(double sales) {
        this.sales = sales;
    }
    public double getSales() {
        return sales;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    public double getCommissionRate() {
        return commissionRate;
    }
    
}
