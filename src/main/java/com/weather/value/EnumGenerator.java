package com.weather.value;

import java.lang.reflect.Field;

public class EnumGenerator implements ValueGenerator{
    @Override
    public String generate(Class<?> type) {
        Field enumField = type.getDeclaredFields()[0];
        return String.format("\"%s\"", enumField.getName());
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return Enum.class.isAssignableFrom(type);
    }
}
