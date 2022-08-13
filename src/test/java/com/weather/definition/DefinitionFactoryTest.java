package com.weather.definition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class DefinitionFactoryTest {

    @DisplayName("")
    @Test
    void test1(){
        JsonFieldDefinition root = DefinitionFactory.from(DefinitionTest.class);
        for (JsonFieldDefinition child : root.getChildren()) {
            System.out.println(child);
        }
    }

    static class DefinitionTest{
        private String name;
        private Integer age;
        private boolean gender;
        private ObjectType object;
    }

    static class ObjectType{
        private String value;
    }
}