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

import java.util.ArrayList;
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
    void test3(){
        String json = generator.generateFieldsOfType(BooleanType.class);

        System.out.println(json);
        assertThat(json).isEqualTo("{" +
                "\"test\":true" +
                "}");
    }

    static class BooleanType {
        private Boolean test;
    }

    @DisplayName("4. Array Type")
    @Test
    void test4() {
        String json = generator.generateFieldsOfType(ArrayType.class);

        System.out.println(arrayTestJson());
        assertThat(json).isEqualTo(arrayTestJson());
    }

    private String arrayTestJson() {
        return "{" +
                    "\"test\":[" +
                        "[" +
                            "1" +
                        "]" +
                    "]" +
                "}";
    }

    static class ArrayType {
        private List<List<Integer>> test;
    }


    @DisplayName("5. Integration")
    @Test
    void test5(){
        String json = generator.generateFieldsOfType(IntegrationTest.class);

        System.out.println(json);
        assertThat(json).isEqualTo(integrationJson());
    }

    static class IntegrationTest{
        private String name;
        private Integer age;
        private boolean gender;
        private ObjectType object;
        private List<List<ObjectType>> array;
    }

    static class ObjectType{
        private String value;
    }

    String integrationJson(){
        return "{" +
                "\"name\":\"String\"," +
                "\"age\":1," +
                "\"gender\":true," +
                "\"object\":{" +
                    "\"value\":\"String\"" +
                "}," +
                "\"array\":[" +
                    "[" +
                        "{" +
                            "\"value\":\"String\"" +
                        "}" +
                    "]" +
                "]" +
                "}";
    }
}