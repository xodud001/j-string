package com.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class StandardJsonGenerator implements JsonGenerator {

    private final static Logger log = LoggerFactory.getLogger(StandardJsonGenerator.class);

    public <T> String generate(Class<T> type){

        // Type에서 필드 전부 읽음
        Field[] declaredFields = type.getDeclaredFields();

        StringBuilder builder = new StringBuilder();
        for (Field declaredField : declaredFields) {
            Class<?> fieldType = declaredField.getType();

            builder.append("\"").append(declaredField.getName()).append("\":");
            if(String.class.equals(fieldType)){
                builder.append("\"").append("String").append("\",");
            }
            else if(Number.class.isAssignableFrom(fieldType)){
                builder.append(1).append(",");
            }
            else if(Enum.class.isAssignableFrom(fieldType)){
                Field enumField = fieldType.getDeclaredFields()[0];
                builder.append("\"").append(enumField.getName()).append("\"").append(",");
            }

        }
        return "{" + builder.toString().substring(0, builder.length()-1) + "}";
    }

}