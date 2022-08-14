package com.weather;

import com.weather.printer.FieldPrinter;
import com.weather.printer.GenericPrinter;
import com.weather.value.BooleanGenerator;
import com.weather.value.NumberGenerator;
import com.weather.value.StringGenerator;
import com.weather.value.ValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class JsonGeneratorTest {

    FieldPrinter fieldPrinter;
    GenericPrinter genericPrinter;
    JsonGenerator generator;

    @BeforeEach
    public void init(){
        List<ValueGenerator> generators = new ArrayList<>();
        generators.add(new StringGenerator());
        generators.add(new NumberGenerator());
        generators.add(new BooleanGenerator());

        generator = new StandardJsonGenerator(generators);
    }

    @DisplayName("1. String Type")
    @Test
    void test1(){
        String json = generator.generateFieldsOfType(StringType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                        "\"test\":\"String\"" +
                "}");
    }

    static class StringType{
        private String test;
    }

    @DisplayName("2. Number Type")
    @Test
    void test2(){
        String json = generator.generateFieldsOfType(NumberType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                "\"test\":1" +
                "}");
    }

    static class NumberType {
        private Integer test;
    }

    @DisplayName("3. Boolean Test")
    @Test
    void test5(){
        String json = generator.generateFieldsOfType(BooleanType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                "\"test\":true" +
                "}");
    }

    static class BooleanType {
        private Boolean test;
    }

    @DisplayName("4. Collection Type")
    @Test
    void test6() {
        String json = generator.generateFieldsOfType(CollectionType.class);

        System.out.println(collectionTestJson());
        assertThat(json).isEqualTo(collectionTestJson());
    }

    private String collectionTestJson() {
        return "{" +
                    "\"test\":[" +
                        "[" +
                            "1" +
                        "]" +
                    "]" +
                "}";
    }

    static class CollectionType{
        private List<List<Integer>> test;
    }

}