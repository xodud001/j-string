package com.weather.field;

import java.lang.reflect.Field;

public class StringGenerator extends AbstractFieldGenerator{

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return String.class.equals(fieldType);
    }

    @Override
    protected String createValue(Field field) {
        return "\"String\"";
    }
}
