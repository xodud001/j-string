package com.weather.definition;

import com.weather.JsonType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.*;

public class DefinitionFactory {

    public static JsonFieldDefinition from(Class<?> type){
        List<JsonFieldDefinition> children = getJsonFieldDefinitions(type);
        return new ObjectType(null, JsonType.OBJECT, children);
    }

    private static JsonFieldDefinition from(String fieldName, Class<?> type){
        List<JsonFieldDefinition> children = getJsonFieldDefinitions(type);
        return new ObjectType(fieldName, JsonType.OBJECT, children);
    }

    @NotNull
    private static List<JsonFieldDefinition> getJsonFieldDefinitions(Class<?> type) {
        List<JsonFieldDefinition> children = new ArrayList<>();

        Field[] declaredFields = type.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            children.add(getJsonFieldDefinition(declaredField));
        } return children;
    }

    private static JsonFieldDefinition getJsonFieldDefinition(Field field){
        Objects.requireNonNull(field);

        Class<?> currentType = field.getType();
        return generateJsonDefinition(field, currentType);
    }

    private static JsonFieldDefinition generateJsonDefinition(Field field, Class<?> currentType) {
        JsonType jsonType = JsonType.getJsonType(currentType);
        String fieldName = field == null ? null : field.getName();
        switch(jsonType){
            case OBJECT:
                return from(fieldName, currentType);
            case ARRAY:
                return generateArrayDefinition(field);
            default:
                return new NormalType(fieldName, jsonType, currentType);
        }
    }

    private static JsonFieldDefinition generateArrayDefinition(Field field){

        String[] types = tokenizeGenericType(field);
        Queue<Class<?>> classes = new LinkedList<>();

        for (int i = 1; i < types.length; i++) {
            Class<?> genericClass;
            try {
                genericClass = Class.forName(types[i]);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(types[i] + " is invalid class name.", e);
            }
            classes.offer(genericClass);
        }
        JsonFieldDefinition child = generateArrayDefinitionTree(classes);
        List<JsonFieldDefinition> children = new ArrayList<>();
        children.add(child);

        return new ArrayType(field.getName(), JsonType.ARRAY, children);
    }

    private static JsonFieldDefinition generateArrayDefinitionTree(Queue<Class<?>> classes){
        if(classes.isEmpty()) return null;

        Class<?> currentType = classes.remove();
        JsonType jsonType = JsonType.getJsonType(currentType);

        switch(jsonType){
            case OBJECT:
                return from(null, currentType);
            case ARRAY:
                JsonFieldDefinition child = generateArrayDefinitionTree(classes);
                List<JsonFieldDefinition> children = new ArrayList<>();
                children.add(child);
                return new ArrayType(null, JsonType.ARRAY, children);
            default:
                return new NormalType(null, jsonType, currentType);
        }

    }


    private static String[] tokenizeGenericType(Field field) {
        //List<List<Integer>> => List, List, Integer
        return field.getGenericType().getTypeName().replaceAll(">", "").split("<");
    }

}
