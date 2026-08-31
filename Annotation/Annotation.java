package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Info{
    String department();
    String role();
}

@Info(department="AI&DS",role = "Software Engineer")
class Annotate{}

public class Annotation {
    public static void main(String[] args) {
        Class<Annotate> obj = Annotate.class;
        Info info = obj.getAnnotation(Info.class);
        System.out.println("Employee ID : 1\nEmployee Name : Daniel\nDepartment : "+info.department()+"\nRole : "+info.role());
    }
}