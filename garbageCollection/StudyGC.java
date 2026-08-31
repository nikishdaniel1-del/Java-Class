package garbageCollection;

class EmployeeHRMS{
    private String id,name;
    EmployeeHRMS(String id,String name) {
        this.id = id;
        this.name = name;
    }
    void display(){
        System.out.println(id+" - "+name);
    }
}
public class StudyGC {
    public static void main(String[] args){
        EmployeeHRMS employee = new EmployeeHRMS("1", "Daniel");
        employee.display();
        employee = null;
        System.out.println("Employee reference removed");
        System.gc();
        System.out.println("Employee Object Eligible for Garbage collection.");
    }
}