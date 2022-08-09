package com.weather.field;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanGenerator implements FieldGenerator {

    @Override
    public String generateField(Field field) {
        return "\"true\"";
    }

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return boolean.class.equals(fieldType) ||
                Boolean.class.equals(fieldType) ||
                AtomicBoolean.class.equals(fieldType);
    }
}
