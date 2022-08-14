package com.weather.definition;

import com.weather.JsonType;

import java.util.ArrayList;
import java.util.List;

public abstract class BasedDefinition implements JsonFieldDefinition {
    private final String keyName;

    private final JsonType valueType;
    private final Class<?> valueClass;
    private final List<JsonFieldDefinition> children = new ArrayList<>();
    private final boolean isRequiredKeyName;
    protected BasedDefinition(String keyName, JsonType valueType, Class<?> valueClass, List<JsonFieldDefinition> children) {
        this.keyName = keyName;
        this.valueType = valueType;
        this.valueClass = valueClass;
        if(children != null){
            this.children.addAll(children);
        }
        this.isRequiredKeyName = keyName != null;
    }

    @Override
    public String getKeyName() {
        return this.keyName;
    }

    @Override
    public JsonType getValueType() {
        return this.valueType;
    }

    @Override
    public Class<?> getValueClass() {
        return this.valueClass;
    }

    @Override
    public List<JsonFieldDefinition> getChildren() {
        return this.children;
    }

    @Override
    public boolean isRequiredKeyName() {
        return this.isRequiredKeyName;
    }
}
