package item35.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException{
        int tests = 0;
        int passed = 0;

        Class clazz = Class.forName("item35.annotation.Sample");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m: methods
                ) {
            tests++;
            if(m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (IllegalAccessException e) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d,  Failed: %d%n", passed, tests - passed);
    }
}
