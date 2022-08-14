package com.weather.printer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class GenericPrinter {

    public void print(Type type){
        ParameterizedType parameterizedType = (ParameterizedType) type;

        System.out.println(parameterizedType.getTypeName());
        System.out.println(parameterizedType.getOwnerType());
        System.out.println(parameterizedType.getRawType());
        System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
    }
}
