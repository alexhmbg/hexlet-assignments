package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        Method[] declaredMethods = address.getClass().getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(method -> method.isAnnotationPresent(Inspect.class))
                .forEach(method -> System.out.println("Method "
                        + method.getName()
                        + " returns a value of type "
                        + method.getReturnType().getSimpleName()));
        // END
    }
}
