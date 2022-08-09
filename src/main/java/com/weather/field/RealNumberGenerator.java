package com.weather.field;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RealNumberGenerator implements FieldGenerator{

    @Override
    public String generateField(Field field) {
        return "1.0";
    }

    @Override
    public boolean isSupported(Class<?> fieldType) {
        return float.class.equals(fieldType) ||
                double.class.equals(fieldType) ||
                Float.class.equals(fieldType) ||
                Double.class.equals(fieldType);
    }
}
