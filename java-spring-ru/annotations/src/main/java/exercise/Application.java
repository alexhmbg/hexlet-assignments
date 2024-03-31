package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);
        // BEGIN
        for (Method method : address.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                var methodName = method.getName();
                var methodReturnType = method.getReturnType();
                var result = String.format("Method %s returns a value of type %s.", methodName, methodReturnType);
                System.out.println(result);
            }
        }
        // END
    }
}
