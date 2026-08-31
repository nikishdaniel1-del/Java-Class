package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeStatus{
    String status();
}
@EmployeeStatus(status = "Active")
class EmployeeStatusA{}
public class AnnotationStatus {
    public static void main(String[] args) {
        Class<EmployeeStatusA> employee = EmployeeStatusA.class;
        EmployeeStatus status = employee.getAnnotation(EmployeeStatus.class);
        System.out.println("Employee ID : 1\nName : Daniel\nStatus : "+status.status());
    }
}