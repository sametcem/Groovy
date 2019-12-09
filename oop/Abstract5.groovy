package oop

/*
First, while abstract classes may contain fields/properties and concrete methods,
interfaces may contain only abstract methods (method signatures).
Moreover, one class can implement several interfaces, whereas it can extend just one class, abstract or not.
 */
abstract class Abstract5 {
    String name

    abstract def abstractMethod()

    def concreteMethod() {
        println "concrete"
    }
}
