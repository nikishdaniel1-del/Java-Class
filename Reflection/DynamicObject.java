package Reflection;
import java.lang.reflect.Constructor;

class Dynamic{
    public Dynamic(){
        System.out.println("Object Created");
    }
}
public class DynamicObject {
    public static void main(String[] args) throws Exception{
        Constructor<Dynamic> dynamic = Dynamic.class.getDeclaredConstructor();
        Dynamic obj = dynamic.newInstance();
    }
}