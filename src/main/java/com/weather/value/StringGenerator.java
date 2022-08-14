package com.weather.value;

public class StringGenerator implements ValueGenerator{

    @Override
    public String generate(Class<?> type) {
        return String.format("\"%s\"", "String");
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return String.class.equals(type);
    }
}
