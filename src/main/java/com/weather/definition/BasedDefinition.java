package com.weather.definition;

import com.weather.JsonType;

import java.util.ArrayList;
import java.util.List;

public abstract class BasedDefinition implements JsonFieldDefinition {

    private final String keyName;
    private final JsonType valueType;
    private final List<JsonFieldDefinition> children = new ArrayList<>();
    private final boolean isRequiredKeyName;

    protected BasedDefinition(String keyName, JsonType valueType, List<JsonFieldDefinition> children) {
        this.keyName = keyName;
        this.valueType = valueType;
        this.children.addAll(children);
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
    public boolean hasChild() {
        return this.children.size() > 0;
    }

    @Override
    public boolean isRequiredKeyName() {
        return this.isRequiredKeyName;
    }
}
