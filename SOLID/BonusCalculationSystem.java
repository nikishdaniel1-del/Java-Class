package SOLID;

interface BonusCalculation{
    double calculateBonus();
}
class PermanentBonus implements BonusCalculation{
    public double calculateBonus(){
        return 15000;
    }
}
class ContractBonus implements BonusCalculation{
    public double calculateBonus(){
        return 7000; 
    }
}
class EmployeeBonusProcessor{
    private BonusCalculation strategy;
    public EmployeeBonusProcessor(BonusCalculation strategy) {
        this.strategy = strategy;
    }
    public void processBonus() {
        System.out.println("Salary : " + strategy.calculateBonus());
    }
}
public class BonusCalculationSystem {
    public static void main(String[] args) {
        BonusCalculation strategy = new PermanentBonus();
        EmployeeBonusProcessor processor = new EmployeeBonusProcessor(strategy);
        processor.processBonus();
    }
}