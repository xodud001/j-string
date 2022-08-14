package com.weather.value;

import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanGenerator implements ValueGenerator{
    @Override
    public String generate(Class<?> type) {
        return "true";
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return boolean.class.equals(type) ||
                Boolean.class.equals(type) ||
                AtomicBoolean.class.equals(type);
    }
}
