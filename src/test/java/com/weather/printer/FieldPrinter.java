package com.weather.printer;


import java.lang.reflect.Field;

public class FieldPrinter {

    public void print(Field field){
        System.out.println(field.getName());
        System.out.println(field.getType());
        System.out.println(field.getGenericType());
    }
}
