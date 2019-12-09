package oop

/*
Named Parameters

If no (or a no-arg) constructor is declared, it is possible to create objects by passing parameters
in the form of a map (property/value pairs). This can be in handy in cases where one wants to allow
several combinations of parameters. Otherwise, by using traditional positional parameters it would
be necessary to declare all possible constructors. Having a constructor where the first (and perhaps only)
argument is a Map argument is also supported - such a constructor may also be added using
the groovy.transform.MapConstructor annotation.

 */

class PersonWOConstructor {
    String name
    Integer age

    public static void main(String[] args) {
        def person4 = new PersonWOConstructor() // No parameters given in the instantiation
        def person5 = new PersonWOConstructor(name: 'Marie') // 	name parameter given in the instantiation
        def person6 = new PersonWOConstructor(age: 1) // age parameter given in the instantiation
        def person7 = new PersonWOConstructor(name: 'Marie', age: 2) // name and age parameters given in the instantiation

        println(person7.name + " " + person7.age)
    }
}

