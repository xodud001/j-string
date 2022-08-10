package com.weather.field;

import java.lang.reflect.Field;

public class EnumGenerator extends AbstractFieldGenerator{

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return Enum.class.isAssignableFrom(fieldType);
    }

    @Override
    protected String createValue(Field field) {
        Field enumField = field.getType().getDeclaredFields()[0];
        return "\"" + enumField.getName() + "\"";
    }
}
