package com.weather;

import com.weather.exception.NotSupportedFieldException;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public enum JsonType {

    STRING,
    NUMBER,
    BOOLEAN,
    NULL,
    OBJECT,
    ARRAY;

    public static JsonType getJsonType(Class<?> type){
        Objects.requireNonNull(type);
        if (isArray(type)){
            return ARRAY;
        } else if (isBoolean(type)) {
            return BOOLEAN;   
        } else if (isString(type)){
            return STRING;
        } else if (isNumber(type)){
            return NUMBER;
        } else if(isObject(type)){
            return OBJECT; // Class Loader 기준으로 찾아오기 때문에 맨 마지막으로 가는게 맞는듯
        }

        throw new NotSupportedFieldException(type + " is not supported.");
    }

    private static boolean isObject(Class<?> type) {
        return type.getClassLoader() != null && type.getClassLoader().getParent() != null;
    }

    private static boolean isArray(Class<?> type) {
        return List.class.isAssignableFrom(type) ||
                Set.class.isAssignableFrom(type);
    }

    private static boolean isBoolean(Class<?> type) {
        return boolean.class.equals(type) ||
                Boolean.class.equals(type) ||
                AtomicBoolean.class.equals(type);
    }

    private static boolean isString(Class<?> type) {
        return String.class.equals(type) ||
                Enum.class.isAssignableFrom(type);
    }

    private static boolean isNumber(Class<?> type) {
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
