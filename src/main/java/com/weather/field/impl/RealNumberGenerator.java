package com.weather.field;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RealNumberGenerator extends AbstractFieldGenerator{

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return float.class.equals(fieldType) ||
                double.class.equals(fieldType) ||
                Float.class.equals(fieldType) ||
                Double.class.equals(fieldType);
    }

    @Override
    protected String createValue(Field field) {
        return "1.0";
    }
}
