package oop

/*
A method is defined with a return type or with the def keyword, to make the return type untyped.
A method can also receive any number of arguments, which may not have their types explicitly declared.
Java modifiers can be used normally, and if no visibility modifier is provided, the method is public.

Methods in Groovy always return some value.
If no return statement is provided, the value evaluated in the last line executed will be returned.

//

Named Parameters

Like constructors, normal methods can also be called with named parameters.
To support this notation, a convention is used where the first argument to the method is a Map.
In the method body, the parameter values can be accessed as in normal maps (map.key).
If the method has just a single Map argument, all supplied parameters must be named.


 */
class Method1 {
    def someMethod() { 'method called' } // Method with no return type declared and no parameter
    String anotherMethod() { 'another method called' } // Method with explicit return type and no parameter
    def thirdMethod(param1) { "$param1 passed" } // Method with a parameter with no type defined
    static String fourthMethod(String param1) { "$param1 passed" } // 	Static method with a String parameter


}
