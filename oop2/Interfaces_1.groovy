package oop2

interface Named { // declaration of a normal interface
    String name()
}
trait Greetable2 implements Named { //add Named to the list of implemented interfaces
    String greeting() { "Hello, ${name()}!" }
}
class Personx implements Greetable2 { //declare a class that implements the Greetable trait
    String name() { 'Bob' } //implement the missing name method
}

def p = new Personx()
assert p.greeting() == 'Hello, Bob!' //	the greeting implementation comes from the trait
assert p instanceof Named //make sure Person implements the Named interface
assert p instanceof Greetable2 //make sure Person implements the Greetable trait
