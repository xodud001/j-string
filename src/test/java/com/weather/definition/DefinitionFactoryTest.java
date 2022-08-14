package com.weather.definition;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class DefinitionFactoryTest {

    @Test
    void test1(){
        JsonFieldDefinition root = DefinitionFactory.from(DefinitionTest.class);
        for (JsonFieldDefinition child : root.getChildren()) {
            System.out.println(child);
        }

        assertThat(root.getChildren().size()).isEqualTo(5);
    }

    static class DefinitionTest{
        private String name;
        private Integer age;
        private boolean gender;
        private ObjectType object;
        private List<List<ObjectType>> array;
    }

    static class ObjectType{
        private String value;
    }
}