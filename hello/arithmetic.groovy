package hello

import groovy.transform.Canonical

import java.util.regex.Matcher
import java.util.regex.Pattern

/*
def a = 2
def b = a++ * 3

assert a == 3 && b == 6

def c = 3
def d = c-- * 2

assert c == 2 && d == 6

def e = 1
def f = ++e + 3

assert e == 2 && f == 5

def g = 4
def h = --g + 1

assert g == 3 && h == 4
 */

/*
def a = 4
a += 3

assert a == 7

def b = 5
b -= 3

assert b == 2

def c = 5
c *= 3

assert c == 15

def d = 10
d /= 2

assert d == 5

def e = 10
e %= 3

assert e == 1

def f = 3
f **= 2

assert f == 9
*/

assert 1 + 2 == 3
assert 3 != 4

assert -2 < 3
assert 2 <= 2
assert 3 <= 4

assert 5 > 1
assert 5 >= -2


assert !false
assert true && true
assert true || false


assert (!false && false) == false
assert true || true && false


int a = 0b00101010
assert a == 42

int b = 0b00001000
assert b == 8

assert (a & a) == a // bitwise and
assert (a & b) == b // bitwise and returns common bits
assert (a | a) == a // bitwise or
assert (a | b) == a // bitwise or returns all '1'bits

int mask = 0b11111111 // setting a mask to check only the last 8 bits
assert ((a ^ a) & mask) == 0b00000000 // 	bitwise exclusive or on self returns 0
assert ((a ^ b) & mask) == 0b00100010 // bitwise exclusive or
assert ((~a) & mask)    == 0b11010101 // 	bitwise negation



assert (!true)    == false
assert (!'foo')   == false //	'foo' is a non empty string, evaluating to true, so negation returns false
assert (!'')      == true  // 	'' is an empty string, evaluating to false, so negation returns true
/*
// Instead of
if (string!=null && string.length()>0) {
    result = 'Found'
} else {
    result = 'Not found'
}
*/
def string = ""
result = (string!=null && string.length()>0) ? 'Found' : 'Not found'
println(result)
string = "a";
result = string ? 'Found' : 'Not found'
println(result)


// ELVIS OPERATOR
//the "Elvis operator" is a shortening of the ternary operator. One instance of where this is handy is for returning a 'sensible default' value if an expression resolves to false-ish (as in Groovy truth)
def user = [name: ""]
displayName = user.name ? user.name : 'Anonymous'
println(displayName)
user = [name: "Samet"]
displayName = user.name ?: 'Anonymous'
println(displayName)

class Student {
    String name
    int id
}

def stds = [
        new Student(name: 'Peugeot', id: 1223),
        new Student(name: "RAPO", id: 123)]

def std = stds.find { it.id == 123 }
def name = std?.name
assert name == "RAPO"

class User {
    public final String name
    User(String name) { this.name = name}
    String getName() { "Name: $name" }
}
def userx = new User('Bob')
assert userx.name == 'Name: Bob'

//The userx.name call triggers a call to the property of the same name, that is to say, here, to the getter for name.
// ,If you want to retrieve the field instead of calling the getter, you can use the direct field access operator,:
assert userx.@name == 'Bob'

//The method pointer operator (.&) call be used to store a reference to a method in a variable, in order to call it later:

def str = 'example of method reference'
def fun = str.&toUpperCase
def upper = fun()
assert upper == str.toUpperCase()

/*
class Person {
    public final String name;
    public final int age;
    Person(String name,int age) {
        this.name = name;
        this.age = age; }
}
*/
// Method pointer operator

def transform(List elements, Closure action) {
    def result = []
    elements.each {
        result << action(it)
    }
    result
}

String describe(Person p) {
    "$p.name is $p.age"
}

def action = this.&describe
def list = [
        new Person(name: "Bob",   age: 42),
        new Person(name: "Julia", age: 35)]
assert transform(list, action) == ['Bob is 42', 'Julia is 35']

//Arguments are resolved at runtime, meaning that if you have multiple methods with the same name, the syntax is not different,
// only resolution of the appropriate method to be called will be done at runtime

def doSomething(String str) { str.toUpperCase() } //define an overloaded doSomething method accepting a String as an argument
def doSomething(Integer x) { 2*x } // 	define an overloaded doSomething method accepting an Integer as an argument
def reference = this.&doSomething // 	create a single method pointer on doSomething, without specifying argument types
assert reference('foo') == 'FOO'
assert reference(123)   == 246




//Regular Expression Operators

//Pattern Operator
//The pattern operator (~) provides a simple way to create a java.util.regex.Pattern instance
def p = ~/foo/
assert p instanceof Pattern

Pattern pattern

p = ~'foo' //using single quote strings
p = ~"foo" //	using double quotes strings
p = ~$/dollar/slashy $ string/$ //	the dollar-slashy string lets you use slashes and the dollar sign without having to escape them
p = ~"${pattern}" //	you can also use a GString!


// Find Operator

//Alternatively to building a pattern, you can directly use the find operator =~ to build a java.util.regex.Matcher

def text = "some text to match"
def m = text =~ /match/ //=~ creates a matcher against the text variable, using the pattern on the right hand side
assert m instanceof Matcher // the return type of =~ is a Matcher
if(!m) { //equivalent to calling if (!m.find())
    throw new RuntimeException("Oopps,, text not found!")
}

//The match operator (==~) is a slight variation of the find operator, that does not return a Matcher
// but a boolean and requires a strict match of the input string

m = text ==~ /match/ //==~ matches the subject with the regular expression, but match must be strict
assert m instanceof Boolean //	the return type of ==~ is therefore a boolean
if (m) { //equivalent to calling if (text ==~ /match/)
    throw new RuntimeException("Should not reach that point!") }


// SPREAD OPERATOR
//The Spread-dot Operator (*.), often "abbreviated" to just Spread Operator, is used to invoke an action on all items of an aggregate object.
// It is equivalent to calling the action on each item and collecting the result into a list

class Car {
    String make
    String model
}

def cars = [
        new Car(make: 'Peugeot', model: '508'),
        new Car(make: 'Renault', model: 'Clio')]

def makes = cars*.make //The expression cars*.make is equivalent to cars.collect{ it.make }
assert makes == ['Peugeot','Renault']


//The spread operator is null-safe, meaning that if an element of the collection is null,
// it will return null instead of throwing a NullPointerException


cars = [
        new Car(make: 'Peugeot', model: '508'),
        null, // build a list for which of  the elements is null
        new Car(make: 'Renault', model: 'Clio')]
assert cars*.make == ['Peugeot', null, 'Renault'] //using the spread operator will not throw a NullPointerException
assert null*.make == null //the receiver might also be null, in which case the return value is null


// The spread operator can be used on any class which implements the Iterable interface


class Component{
    Long id
    String name
}

class CompositeObject implements Iterable<Component> {
    def components = [
            new Component(id: 1, name: 'Foo'),
            new Component(id: 2, name: 'Bar')]

    @Override
    Iterator<Component> iterator() {
        components.iterator()
    }
}

def composite = new CompositeObject()
assert composite*.id == [1,2]
assert composite*.name == ['Foo','Bar']




