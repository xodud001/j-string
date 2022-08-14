package com.weather;


import com.weather.definition.DefinitionFactory;
import com.weather.definition.JsonFieldDefinition;
import com.weather.exception.NotSupportedFieldException;
import com.weather.value.ValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class StandardJsonGenerator implements JsonGenerator {

    private final List<ValueGenerator> valueGenerators;

    public StandardJsonGenerator(List<ValueGenerator> valueGenerators) {
        this.valueGenerators = valueGenerators;
    }

    public <T> String generateFieldsOfType(Class<T> type){
        JsonFieldDefinition root = DefinitionFactory.from(type);
        return generate(root);
    }

    private String generate(JsonFieldDefinition definition){
        switch(definition.getValueType()){
            case OBJECT:
                return generateObjectType(definition);
            case ARRAY:
                return generateArrayType(definition);
            default:
                return generateNormalType(definition);
        }
    }

    private String generateObjectType(JsonFieldDefinition definition) {
        List<JsonFieldDefinition> children = definition.getChildren();
        List<String> fields = new ArrayList<>();
        for (JsonFieldDefinition child : children) {
            fields.add(generate(child));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.size() - 1; i++) {
            builder.append(fields).append(",");
        }
        builder.append(fields.get(fields.size() - 1));

        String result = String.format("{%s}", builder);
        if(definition.isRequiredKeyName()){
            return String.format("\"%s\":%s", definition.getKeyName(), result);
        }else{
            return result;
        }
    }

    private String generateArrayType(JsonFieldDefinition definition) {
        List<JsonFieldDefinition> children = definition.getChildren();

        String result = String.format("[%s]", generate(children.get(0)));;
        if(definition.isRequiredKeyName()){
            return String.format("\"%s\":%s", definition.getKeyName(), result);
        }else{
            return result;
        }
    }

    private String generateNormalType(JsonFieldDefinition definition) {
        Class<?> valueClass = definition.getValueClass();
        String result = valueGenerators.stream().filter(vg -> vg.isSupported(valueClass))
                .map(vg -> vg.generate(valueClass))
                .findFirst()
                .orElseThrow(() -> new NotSupportedFieldException(valueClass + " is not supported type."));

        if(definition.isRequiredKeyName()){
            return String.format("\"%s\":%s", definition.getKeyName(), result);
        }else{
            return result;
        }
    }
}