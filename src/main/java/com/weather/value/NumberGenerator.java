package com.weather.value;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class NumberGenerator implements ValueGenerator{

    @Override
    public String generate(Class<?> type) {
        return "1";
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return byte.class.equals(type) ||
                short.class.equals(type) ||
                int.class.equals(type) ||
                long.class.equals(type) ||
                Byte.class.equals(type) ||
                Short.class.equals(type) ||
                Integer.class.equals(type) ||
                Long.class.equals(type) ||
                AtomicInteger.class.equals(type) ||
                AtomicLong.class.equals(type) ||
                float.class.equals(type) ||
                double.class.equals(type) ||
                Float.class.equals(type) ||
                Double.class.equals(type);
    }
}
