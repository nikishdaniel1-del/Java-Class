package SOLID;

interface SalaryCalculation {
    double calculateSalary();
}

class PermanentContract implements SalaryCalculation {
    public double calculateSalary() {
        return 50000;
    }
}

class ContractEmployee implements SalaryCalculation {
    public double calculateSalary() {
        return 30000;
    }
}

class SalaryProcessor {
    private SalaryCalculation strategy;
    public SalaryProcessor(SalaryCalculation strategy) {
        this.strategy = strategy;
    }
    public void processSalary() {
        System.out.println("Salary : " + strategy.calculateSalary());
    }
}

public class HRMSStrategyDemo {

    public static void main(String[] args) {
        SalaryCalculation strategy = new PermanentContract();
        SalaryProcessor processor = new SalaryProcessor(strategy);
        processor.processSalary();
    }
}