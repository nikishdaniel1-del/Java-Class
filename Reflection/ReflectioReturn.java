package Reflection;

import java.lang.reflect.Method;

class ReturnClass {
    public String value() {
        return "Daniel";
    }
}

public class ReflectioReturn {
    public static void main(String[] args) throws Exception {
        ReturnClass returnClass = new ReturnClass();
        Method method = ReturnClass.class.getDeclaredMethod("value");
        System.out.println("Employee Name : " + method.invoke(returnClass));
    }
}