package exercise;

import java.lang.reflect.Field;

// BEGIN
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        var result = new ArrayList<String>();
        for (Field field : fields) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
// END
