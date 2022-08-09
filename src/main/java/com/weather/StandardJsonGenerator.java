package com.weather;

import com.weather.exception.NotSupportedFieldException;
import com.weather.field.FieldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StandardJsonGenerator implements JsonGenerator {

    private final static Logger log = LoggerFactory.getLogger(StandardJsonGenerator.class);

    private final List<FieldGenerator> fieldGenerators;

    public StandardJsonGenerator(List<FieldGenerator> fieldGenerators) {
        this.fieldGenerators = fieldGenerators;
    }

    public <T> String generate(Class<T> type){

        // Type에서 필드 전부 읽음
        Field[] declaredFields = type.getDeclaredFields();

        StringBuilder builder = new StringBuilder();

        //모든 필드 순회
        for (Field declaredField : declaredFields) {
            String key = createFieldName(declaredField.getName());
            String value = fieldGenerators.stream()
                    .filter(fg -> fg.isSupported(declaredField.getType()))
                    .map(fg -> fg.generateField(declaredField))
                    .findFirst()
                    .orElseThrow(() -> new NotSupportedFieldException(declaredField.getType() + "is don't support."));

            String parsedField = key + value;
            builder.append(parsedField).append(",");
        }
        return "{" + builder.substring(0, builder.length()-1) + "}";
    }

    private String createFieldName(String name) {
        return "\"" + name + "\":";
    }

    private boolean isAllSupported(Field[] declaredFields){
        int supportedCount = 0;
        for (Field declaredField : declaredFields) {
            supportedCount += fieldGenerators.stream().filter(g -> g.isSupported(declaredField.getType())).count();
        }

        return supportedCount == declaredFields.length;
    }

}