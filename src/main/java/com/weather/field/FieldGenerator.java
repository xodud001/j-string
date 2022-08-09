package com.weather.field;

import java.lang.reflect.Field;

public interface FieldGenerator {

    String generateField(Field field);

    boolean isSupported(Class<?> fieldType);
}
