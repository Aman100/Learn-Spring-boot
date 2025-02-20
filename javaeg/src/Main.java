import java.util.*;
import java.util.stream.*;
import java.lang.reflect.*;
class Laptop
{
    private String name;
    private static Laptop laptop;
    private Laptop(String name)
    {
        System.out.println("name: " + name);
        this.name=name;
    }
    public static Laptop getInstance(String name)
    {
        if(laptop==null) return laptop=new Laptop(name);
        return laptop;
    }
}

class Main
{
    public static void main(String gg[]) throws Exception
    {
        Laptop laptop1=Laptop.getInstance("Dell G16 7630");
        Laptop laptop2=Laptop.getInstance("Dell G16 7630");
        System.out.printf("%d %d",
                System.identityHashCode(laptop1),
                System.identityHashCode(laptop2));
        Constructor<Laptop> cl =Laptop.class.getDeclaredConstructor(String.class);
        cl.setAccessible(true);
        Object l = cl.newInstance("Dell G15");
        Method method=Laptop.class.getMethod("getInstance",String.class);
        method.invoke(l,"Dell G18");
    }
}
