package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            field.setAccessible(true);
            try {
                if (annotation != null && field.get(obj) == null) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                System.out.println("field: " + field.getName() + " is not accessible");
            }
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> result = new HashMap<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
            field.setAccessible(true);
            try {
                if (notNull != null && field.get(obj) == null) {
                    result.put(field.getName(), List.of("can not be null"));
                }
                if (minLength != null && minLength.minLength() > field.get(obj).toString().length()) {
                    result.put(field.getName(), List.of("length less than " + minLength.minLength()));
                }
            } catch (IllegalAccessException e) {
                System.out.println("field: " + field.getName() + " is not accessible");
            }
        }

        return result;
    }
}

//  Address address = new Address("USA", "Texas", null, "7", "2");
//  Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
//  System.out.println(notValidFields); // =>  {country=[length less than 4], street=[can not be null]}

// END
