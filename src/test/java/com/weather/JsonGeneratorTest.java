package com.weather;

import com.weather.printer.FieldPrinter;
import com.weather.printer.GenericPrinter;
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
    JsonGenerator generator = new StandardJsonGenerator();

    @DisplayName("1. String Type")
    @Test
    void test1(){
        String json = generator.generateFieldsOfType(StringType.class);

        assertThat(json).isEqualTo("{" +
                        "\"test\":\"String\"" +
                "}");
    }

    static class StringType{
        private String test;
    }

    @DisplayName("2. Integer Type")
    @Test
    void test2(){
        String json = generator.generateFieldsOfType(IntegerType.class);

        assertThat(json).isEqualTo("{" +
                "\"test\":1" +
                "}");
    }

    static class IntegerType {
        private Integer test;
    }

    @DisplayName("3. Enum Type")
    @Test
    void test3(){
        String json = generator.generateFieldsOfType(EnumType.class);

        assertThat(json).isEqualTo("{" +
                "\"test\":\"TYPE1\"" +
                "}");
    }

    static class EnumType{
        private TestEnum test;
    }

    static enum TestEnum{
        TYPE1,
        TYPE2;
    }

    @DisplayName("4. RealNumber Test")
    @Test
    void test4(){
        String json = generator.generateFieldsOfType(RealNumberType.class);

        assertThat(json).isEqualTo("{" +
                "\"test\":1.0" +
                "}");
    }

    static class RealNumberType {
        private Double test;
    }

    @DisplayName("5. Boolean Test")
    @Test
    void test5(){
        String json = generator.generateFieldsOfType(BooleanType.class);

        assertThat(json).isEqualTo("{" +
                "\"test\":\"true\"" +
                "}");
    }

    static class BooleanType {
        private Boolean test;
    }

    @DisplayName("6. Collection Type")
    @Test
    void test6() {
//        String json = generator.generateFieldsOfType(CollectionType.class);
//
//        System.out.println(json);
//        System.out.println(collectionTestJson());
//        assertThat(json).isEqualTo(collectionTestJson());
        List<Integer> type = new ArrayList<>();
        Class<?> typeClass = type.getClass();
        System.out.println(typeClass);
        System.out.println(Arrays.toString(typeClass.getGenericInterfaces()));
        System.out.println(typeClass.getGenericSuperclass());
        System.out.println(typeClass.getDeclaringClass());
        System.out.println(typeClass.getTypeName());
        System.out.println(typeClass.getCanonicalName());
        System.out.println(typeClass.getComponentType());
        System.out.println(typeClass.getName());
        System.out.println(Arrays.toString(typeClass.getSigners()));
        System.out.println(Arrays.toString(typeClass.getTypeParameters()));


    }

    private String collectionTestJson() {
        return "{" +
                "\"test\":[" +
                "1,1,1" +
                "]" +
                "}";
    }

    static class CollectionType{
        private List<Integer> numbers;
    }

    @DisplayName("")
    @Test
    void test7() throws ClassNotFoundException, NoSuchFieldException {
        Class<ClassForNameTest> classForNameTestClass = ClassForNameTest.class;
        for (Field declaredField : classForNameTestClass.getDeclaredFields()) {
            System.out.println(Arrays.toString(declaredField.getGenericType().getTypeName().replaceAll(">", "").split("<")));
        }

        ClassLoader classLoader = classForNameTestClass.getClassLoader();
        System.out.println(classLoader);
        Field integers = classForNameTestClass.getDeclaredField("integers");
        System.out.println(integers.getGenericType().getClass().getClassLoader());
    }

    static class ClassForNameTest{
        List<List<Integer>> integers;
        int n1;
    }
}