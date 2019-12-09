package oop

//Named Parameters
class Method2 {
    String name
    Integer age

    def static foo(Map args) { "${args.name}: ${args.age}" }
    def static foo2(Map args, Integer number) { "${args.name}: ${args.age}, and the number is ${number}" }
    def static foo3(Integer number, Map args) { "${args.name}: ${args.age}, and the number is ${number}" }

    def static fooA(String par1, Integer par2 = 1) { [name: par1, age: par2] }

     static void main(String[] args) {
         println(foo(name: 'Marie', age: 1))
         println(foo2(name: 'Marie', age: 1, 23)) // 	Method call with additional number argument of Integer type
         println(foo2(23, name: 'Marie', age: 1) ) // Method call with changed order of arguments

         // If we don’t have the Map as the first argument, then a Map must be supplied for that argument instead of named parameters.
         // Failure to do so will lead to groovy.lang.MissingMethodException: FIRST MAP

        println(foo3(23, [name: 'Marie', age: 1]))


         //Default arguments make parameters optional. If the argument is not supplied, the method assumes a default value.
         assert fooA('Marie').age == 1


    }
}
