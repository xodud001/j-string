package com.weather.definition;

import com.weather.JsonType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DefinitionFactory {


    // Object
    public static JsonFieldDefinition from(Class<?> type){
        List<JsonFieldDefinition> childs = getJsonFieldDefinitions(type);
        return new ObjectType(null, JsonType.OBJECT, childs);
    }

    public static JsonFieldDefinition from(String fieldName, Class<?> type){
        List<JsonFieldDefinition> childs = getJsonFieldDefinitions(type);
        return new ObjectType(fieldName, JsonType.OBJECT, childs);
    }

    @NotNull
    private static List<JsonFieldDefinition> getJsonFieldDefinitions(Class<?> type) {
        List<JsonFieldDefinition> childs = new ArrayList<>();

        Field[] declaredFields = type.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.getGenericType();
        } return childs;
    }

    // Array - 제네릭 타입 지원

    // Normal
}
