package com.weather.field;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanGenerator extends AbstractFieldGenerator {

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return boolean.class.equals(fieldType) ||
                Boolean.class.equals(fieldType) ||
                AtomicBoolean.class.equals(fieldType);
    }

    @Override
    protected String createValue(Field field) {
        return "\"true\"";
    }
}
