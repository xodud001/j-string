package com.weather.field;


import com.weather.StandardJsonGenerator;
import com.weather.field.impl.*;

import java.util.ArrayList;
import java.util.List;

public class FieldGeneratorFactory {

    private final static BooleanGenerator BOOLEAN_GENERATOR = new BooleanGenerator();
    private final static IntegerGenerator INTEGER_GENERATOR = new IntegerGenerator();
    private final static RealNumberGenerator REAL_NUMBER_GENERATOR = new RealNumberGenerator();
    private final static StringGenerator STRING_GENERATOR = new StringGenerator();
    private final static EnumGenerator ENUM_GENERATOR = new EnumGenerator();
    private final static CollectionGenerator COLLECTION_GENERATOR = new CollectionGenerator();


    public static List<FieldGenerator> getFieldGenerators(){
        List<FieldGenerator> lists = new ArrayList<>();
        lists.add(BOOLEAN_GENERATOR);
        lists.add(INTEGER_GENERATOR);
        lists.add(REAL_NUMBER_GENERATOR);
        lists.add(STRING_GENERATOR);
        lists.add(ENUM_GENERATOR);
        lists.add(COLLECTION_GENERATOR);
        return lists;
    }
}
