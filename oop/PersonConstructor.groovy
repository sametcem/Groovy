package oop

//If no constructors are supplied, an empty no-arg constructor will be provided by the Groovy compiler. ( Java Default Constructor)

//positional parameters are used in a similar to how you would use Java constructors
//named parameters allow you to specify parameter names when invoking the constructor.

// POSITIONAL PARAMETER
// One or more constructors.
//The constructors can also added to the class using the groovy.transform.TupleConstructor annotation.
class PersonConstructor {
    String name
    int age

    PersonConstructor(name,age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        def person1 = new PersonConstructor('Marie', 1) // Constructor invocation, classic Java way
        def person2 = ['Marie', 2] as PersonConstructor // 	Constructor usage, using coercion with as keyword
        PersonConstructor person3 = ['Marie', 3] // Constructor usage, using coercion in assignment

    }


}
