package Interface;

interface Payment {
    void processPayment();
}
class SalaryPayment implements Payment {
    public void processPayment() {
        System.out.println("Salary Payment Done.");
    }
}
class BonusPayment implements Payment {
    public void processPayment() {
        System.out.println("Bonus Payment Done.");
    }
}
class ReimbursementPayment implements Payment {
    public void processPayment() {
        System.out.println("Reimbursement Payment Done.");
    }
}
class FinanceDepartment {
    public Payment makePayment(String type) {
        if ("SALARY".equalsIgnoreCase(type)) {
            return new SalaryPayment();
        }
        else if ("BONUS".equalsIgnoreCase(type)) {
            return new BonusPayment();
        }
        else if ("REIMBURSEMENT".equalsIgnoreCase(type)) {
            return new ReimbursementPayment();
        }
        throw new IllegalArgumentException("Invalid Payment type : " + type);
    }
}
public class HRMS {
    public static void main(String[] args) {
        FinanceDepartment finance = new FinanceDepartment();
        Payment payment1 = finance.makePayment("SALARY");
        payment1.processPayment();
        Payment payment2 = finance.makePayment("BONUS");
        payment2.processPayment();
        Payment payment3 = finance.makePayment("REIMBURSEMENT");
        payment3.processPayment();
    }
}