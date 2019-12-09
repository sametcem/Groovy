package oop

//A property is an externally visible feature of a class.
class Properties {
    //Groovy will then generate the getters/setters appropriately. For example:

    String name // creates a backing private String name field, a getName and a setName method
    int age // 	creates a backing private int age field, a getAge and a setAge method

    class Person{
        final String namex  //	defines a read-only property of type String
        final int agex // 	defines a read-only property of type int

        Person(String namex, int agex) {
            this.namex = namex //	assigns the name parameter to the name field
            this.agex = agex //	assigns the age parameter to the age field
        }
    }

}
