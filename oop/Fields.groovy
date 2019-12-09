package oop

//A field is a member of a class or a trait
class Fields {
    private int id  //	a private field named id, of type int
    protected String description //a protected field named description, of type String
    public static final boolean DEBUG = false //a public static final field named DEBUG of type boolean
}

//A field may be initialized directly at declaration:

/*

class Data {
    private String id = IDGenerator.next()  // the private field id is initialized with IDGenerator.next()
    // ...
}

 */

/*
It is possible to omit the type declaration of a field.
This is however considered a bad practice and in general it is a good idea to use strong typing for fields:


class BadPractice {
    private mapping //	the field mapping doesn’t declare a type
}
class GoodPractice {
    private Map<String,String> mapping //the field mapping has a strong type
}


 */



