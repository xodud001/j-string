package com.weather.definition;

import com.weather.JsonType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefinitionFactory {

    public static JsonFieldDefinition from(Class<?> type){
        List<JsonFieldDefinition> childs = getJsonFieldDefinitions(type);
        return new ObjectType(null, JsonType.OBJECT, childs);
    }

    private static JsonFieldDefinition from(String fieldName, Class<?> type){
        List<JsonFieldDefinition> childs = getJsonFieldDefinitions(type);
        return new ObjectType(fieldName, JsonType.OBJECT, childs);
    }

    @NotNull
    private static List<JsonFieldDefinition> getJsonFieldDefinitions(Class<?> type) {
        List<JsonFieldDefinition> childs = new ArrayList<>();

        Field[] declaredFields = type.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            childs.add(getJsonFieldDefinition(declaredField));
        } return childs;
    }

    // Array - 제네릭 타입 지원

    private static JsonFieldDefinition getJsonFieldDefinition(Field field){
        Objects.requireNonNull(field);

        Class<?> currentType = field.getType();
        JsonType jsonType = JsonType.getJsonType(currentType);
        switch(jsonType){
            case OBJECT:
                return from(field.getName(), currentType);
            case ARRAY:
                return null;
            default:
                return new NormalType(field.getName(), jsonType);
        }
    }
}
