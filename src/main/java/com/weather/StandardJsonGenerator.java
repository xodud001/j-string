package com.weather;

import com.weather.exception.NotSupportedFieldException;
import com.weather.field.FieldGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

public class StandardJsonGenerator implements JsonGenerator {

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
            String parsedField = fieldGenerators.stream()
                    .filter(fg -> fg.isSupported(declaredField.getType()))
                    .map(fg -> fg.generateField(declaredField))
                    .findFirst()
                    .orElseThrow(() -> new NotSupportedFieldException(declaredField.getType() + "is don't support."));

            builder.append(parsedField).append(",");
        }
        return "{" + builder.substring(0, builder.length()-1) + "}";
    }
}