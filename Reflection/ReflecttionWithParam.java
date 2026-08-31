package Reflection;

import java.lang.reflect.Method;

class Sample{
    private String employeeName = "John";
    public String update(String name){
        this.employeeName = name;
        return "Employee Name : "+this.employeeName;
    }
}

public class ReflecttionWithParam {
    public static void main(String[] args) throws Exception{
        Sample sample = new Sample();
        Method method = Sample.class.getDeclaredMethod("update", String.class);
        System.out.println(method.invoke(sample, "Daniel"));
    }
}