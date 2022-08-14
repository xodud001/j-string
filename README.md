# J-String
J-String is a liblary written in Java that makes it easy for you to generate a JSON string from java class type for the test.

# How to work
When given type, J-String generates `JsonFieldDefinition` Tree.

suppose that there are the below types
```java
class Member{
  private String name;
  private int age;
  private Address address;
  private boolean gender;
  private List<Belonging> belongings;
}
```
```java
class Address{
  private String state;
  private String city;
  private String street;
}
```
```java
class Belonging{
  private String name;
  private int count
}
```

create the below tree.




# Sample

```java
List<ValueGenerator> generators = new ArrayList<>();
generators.add(new StringGenerator());
generators.add(new NumberGenerator());
generators.add(new BooleanGenerator());

JsonGenerator generator = new StandardJsonGenerator(generators);

String json = generator.generateFieldsOfType(IntegrationTest.class);
```

```json
{
  "name":"String",
  "age":1,
  "gender":true,
  "object":{
    "value":"String"
  },
  "array":[
    [
      {
        "value":"String"
      }
    ]
  ]
}
```

# To Do
* support various type
  - DateTime Types
  - Enum Type
* generate a custom value

