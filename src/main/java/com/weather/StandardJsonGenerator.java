package com.weather;


import java.lang.reflect.Field;

public class StandardJsonGenerator implements JsonGenerator {
    public <T> String generateFieldsOfType(Class<T> type){
        // Type에서 필드 전부 읽음
        Field[] declaredFields = type.getDeclaredFields();

        StringBuilder builder = new StringBuilder();

        //모든 필드 순회
        for (Field declaredField : declaredFields) {
            Class<?> currentType = declaredField.getType();

        }
        return "{" + builder.substring(0, builder.length()-1) + "}";
    }
}