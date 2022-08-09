package com.weather.field;

import java.lang.reflect.Field;

public class StringGenerator implements FieldGenerator{

    @Override
    public String generateField(Field field) {
        return "\"String\"";
    }

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return String.class.equals(fieldType);
    }
}
