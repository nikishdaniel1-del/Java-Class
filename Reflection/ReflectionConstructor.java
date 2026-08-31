package Reflection;
import java.lang.reflect.Constructor;

class Declared{
    public Declared(){}
    public Declared(String name){}
}

public class ReflectionConstructor {
    public static void main(String[] args) {
        Constructor<?>[] declared = Declared.class.getDeclaredConstructors();
        for (Constructor<?> constructor : declared){
            System.out.println(constructor);
        }
    }
}