package oop2

/*
Traits are a structural construct of the language which allows:

composition of behaviors

runtime implementation of interfaces

behavior overriding

compatibility with static type checking/compilation

They can be seen as interfaces carrying both default implementations and state. A trait is defined using the trait keyword:

Traits allow a wide range of capabilities, from simple composition to testing, which are described thoroughly in this section

 traits may declare abstract methods too, which therefore need to be implemented in the class implementing the trait:
 */

trait FlyingAbility { //	declaration of a trait
    String fly() { "I'm flying"} //declaration of a method inside a trait
}
trait  Greetable{
    abstract String name() //	implementing class will have to declare the name method
    String greeting() {
        "Hello, ${name()}!" //can be mixed with a concrete method
    }
}

trait Greeter {
    private String greetingMessage(){ //	define a private method greetingMessage in the trait
        'Hello from a private method!'
    }
    String greet(){
        def m = greetingMessage() //the public greet message calls greetingMessage by default
        println m
        m
    }
}

class Bird implements FlyingAbility{} //	Adds the trait FlyingAbility to the Bird class capabilities
def b = new Bird() //instantiate a new Bird
assert b.fly() == "I'm flying" //	the Bird class automatically gets the behavior of the FlyingAbility trait

class Persona implements Greetable{ //	implement the trait Greetable
    String name() {'Bob'} //since name was abstract, it is required to implement it
}

def p = new Persona()
assert p.greeting() == 'Hello, Bob!' //	then greeting can be called


class GreetingMachine implements Greeter{} //	create a class implementing the trait
def g = new GreetingMachine()
assert g.greet() == "Hello from a private method!" //greet can be called

try {
    assert g.greetingMessage() // but not greetingMessage
} catch (MissingMethodException e) {
    println "greetingMessage is private in trait"
}

// Traits only support public and private methods. Neither protected nor package private scopes are supported.

// this represents the implementing instance. Think of a trait as a superclass. This means that when you write:

trait Introspector {
    def whoAmI() {this}
}

class Foo implements Introspector{}
def foo = new Foo()

foo.whoAmI()
assert foo.whoAmI().is(foo)
