package oop2

//Dynamic Code
/*
Traits can call any dynamic code, like a normal Groovy class.
This means that you can, in the body of a method, call methods which are supposed to exist in an implementing class,
without having to explicitly declare them in an interface. This means that traits are fully compatible with duck typing:
 */

trait SpeakingDuck {
    String speak() { quack() } //the SpeakingDuck expects the quack method to be defined
}
class Ducko implements SpeakingDuck {
    String methodMissing(String name, args) { //	the Duck class does implement the method using methodMissing
        "${name.capitalize()}!"
    }
}
def d = new Ducko()
assert d.speak() == 'Quack!' // calling the speak method triggers a call to quack which is handled by methodMissing

//

trait DynamicObject { //create a trait implementing several MOP methods
    private Map props = [:]
    def methodMissing(String name, args) {
        name.toUpperCase()
    }
    def propertyMissing(String prop) {
        props[prop]
    }
    void setProperty(String prop, Object value) {
        props[prop] = value
    }
}

class Dynamic implements DynamicObject {
    String existingProperty = 'ok'   //the Dynamic class defines a property
    String existingMethod() { 'ok' } //	the Dynamic class defines a method
}
def de = new Dynamic()
assert de.existingProperty == 'ok' //	calling an existing property will call the method from Dynami
assert de.foo == null //calling an non-existing property will call the method from the trait
de.foo = 'bar' //will call setProperty defined on the trait
assert de.foo == 'bar' // 	will call getProperty defined on the trait
assert de.existingMethod() == 'ok' //	calling an existing method on Dynamic
assert de.someMethod() == 'SOMEMETHOD' //	but calling a non existing method thanks to the trait methodMissing





