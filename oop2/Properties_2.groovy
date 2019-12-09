package oop2

//Properties
trait Namedx {
    String name //	declare a property name inside a trait
}
class Personb implements Namedx {}
def p = new Personb(name: 'Bob')
assert p.name == 'Bob'
assert p.getName() =='Bob'


//Private Fields
//Since traits allow the use of private methods, it can also be interesting to use private fields to store state. Traits will let you do that:

trait Counter {
    private int count = 0 //declare a private field count inside a trait
    int count() { count += 1; count } //	declare a public method count that increments the counter and returns it
}
class Foox implements Counter {} //	declare a class that implements the Counter trait
def f = new Foox()
assert f.count() == 1 //the count method can use the private field to keep state
assert f.count() == 2

/*
//Public Fields
trait Namedt {
    public String name
}
class Persont implements Namedt {}
def pt = new Persont()
pt.Named__name = 'Bob'
 */

trait FlyingAbility2 {
    String fly() { "I'm flying!" }
}
trait SpeakingAbility {
    String speak() { "I'm speaking!" }
}

class Duck implements FlyingAbility2, SpeakingAbility {
    String quack() { "Quack!" }
    String speak() { quack() }
}

def d = new Duck()
assert d.fly() == "I'm flying!"
//assert d.speak() == "I'm speaking!"
assert d.quack() == "Quack!"
assert d.speak() == "Quack!"


//Extending Traits
//Simply inheritance

trait Namedb {
    String name //	the Named trait defines a single name property
}
trait Polite extends Namedb { //	the Polite trait extends the Named trait
    String introduce() { "Hello, I am $name" } // Polite adds a new method which has access to the name property of the super-trait
}
class Personr implements Polite {}
def pr = new Personr(name: 'Alice') //	the name property is visible from the Person class implementing Polite
assert pr.introduce() == 'Hello, I am Alice' //as is the introduce method

//Multiple Inheritance
trait WithId { //WithId trait defines the id property
    Long id
}
trait WithName { //WithName trait defines the name property
    String name
}
trait Identified implements WithId, WithName {} //Identified is a trait which inherits both WithId and WithName



