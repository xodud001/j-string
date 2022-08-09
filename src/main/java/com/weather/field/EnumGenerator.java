package com.weather.field;

import java.lang.reflect.Field;

public class EnumGenerator implements FieldGenerator{


    @Override
    public String generateField(Field field) {
        Field enumField = field.getType().getDeclaredFields()[0];
        return "\"" + enumField.getName() + "\"";
    }

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return Enum.class.isAssignableFrom(fieldType);
    }
}
