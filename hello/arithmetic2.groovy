package hello

import groovy.transform.Canonical

//Use multiple invocations of the spread-dot operator (here cars*.models*.name)
// when working with aggregates of data structures which themselves contain aggregates:

class Make {
    String name
    List<Model> models
}

@Canonical
class Model {
    String name
}

def cars = [
        new Make(name: 'Peugeot',
                models: [new Model('408'), new Model('508')]),
        new Make(name: 'Renault',
                models: [new Model('Clio'), new Model('Captur')])
]

def makes = cars*.name
assert makes == ['Peugeot', 'Renault']

def models = cars*.models*.name
assert models == [['408', '508'], ['Clio', 'Captur']]
assert models.sum() == ['408', '508', 'Clio', 'Captur'] // flatten one level
assert models.flatten() == ['408', '508', 'Clio', 'Captur'] // flatten all levels (one in this case)


//Consider using the collectNested DGM method instead of the spread-dot operator for collections of collections

class Vehicle {
    String make
    String model
}
def vehicles = [
        [
                new Vehicle(make: 'Peugeot', model: '408'),
                new Vehicle(make: 'Peugeot', model: '508')
        ], [
                new Vehicle(make: 'Renault', model: 'Clio'),
                new Vehicle(make: 'Renault', model: 'Captur')
        ]
]
def modelsx = vehicles.collectNested{ it.model }
assert modelsx == [['408', '508'], ['Clio', 'Captur']]


int function(int x, int y, int z) {
    x*y+z
}

def args = [4,5,6]
assert function(*args) ==26

args = [4]
assert function(*args,5,6) == 26

//When used inside a list literal, the spread operator acts as if the spread element contents were inlined into the list

def items = [4,5]
def list = [1,2,3,*items,6] //	we want to insert the contents of the items list directly into list without having to call addAll
assert list == [1,2,3,4,5,6]

//Spread map elements

def m1 = [c:3, d:4]
def map = [a:1, b:2, *:m1]
assert map == [a:1, b:2, c:3, d:4]


def m2 = [c:3, d:4] //	m2 is the map that we want to inline
def ma2 = [a:1, b:2, *:m1, d: 8] //we use the *:m2 notation to spread the contents of m2 into map, but redefine the key d after spreading
assert ma2 == [a:1, b:2, c:3, d:8] //	map contains all the expected keys, but d was redefined

// RANGE OPERATOR


def range = 0..5
assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
assert (0..<5).collect() == [0, 1, 2, 3, 4]
assert (0..5) instanceof List
assert (0..5).size() == 6

assert ('a'..'d').collect() == ['a','b','c','d']

//SPACESHIP OPERATOR
assert (1 <=> 1) == 0
assert (1 <=> 2) == -1
assert (2 <=> 1) == 1
assert ('a' <=> 'z') == -1

//SUBSCRIPT OPERATOR

//The subscript operator is a short hand notation for getAt or putAt,
// depending on whether you find it on the left hand side or the right hand side of an assignment:

def lista = [0,1,2,3,4]
assert lista[2] == 2
lista[2] = 4
assert lista[0..2] == [0,1,4] //	getAt also supports ranges
lista[0..2] = [6,6,6] // 	so does putAt
assert lista == [6,6,6,3,4]



class Userx {
    Long id
    String name

    def getAt(int i) {
        switch (i) {
            case 0: return id
            case 1: return name
        }
        throw new IllegalArgumentException("No such element $i")
    }

    void putAt(int i, def value) {
        switch (i) {
            case 0: id = value; return
            case 1: name = value; return
        }
        throw new IllegalArgumentException("No such element $i")
    }

}

def user = new Userx(id: 1, name: 'Alex')
assert user[0] == 1
assert user[1] == 'Alex'
user[1] = 'Bob'
assert user.name == 'Bob'
println(user.getAt(0) + user.getAt(1))
user.putAt(1,"Ron")
println(user.getAt(0) + user.getAt(1))


def listx = ['Grace','Rob','Emmy']
assert ('Emmy' in listx) //	equivalent to calling list.contains('Emmy') or list.isCase('Emmy')

//In Groovy, using == to test equality is different from using the same operator in Java. In Groovy, it is calling equals

def list1 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
def list2 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
assert list1 == list2
assert !list1.is(list2)

// Coercion Operator
//The coercion operator (as) is a variant of casting.
// Coercion converts object from one type to another without them being compatible for assignment.


Integer x = 123
String s = (String) x
println(s)

Integer a = 21
String t = a as String
println(t)

/*
When an object is coerced into another, unless the target type is the same as the source type,
coercion will return a new object. The rules of coercion differ depending on the source and target types,
and coercion may fail if no conversion rules are found.
Custom conversion rules may be implemented thanks to the asType method
 */

class Identifiable {
    String name
}

class Usert {
    Long id
    String name
    def asType(Class target) { //	the User class defines a custom conversion rule from User to Identifiable
        if (target == Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }
}

def u = new Usert(name: 'Xavier') //we create an instance of User
def p = u as Identifiable //	we coerce the User instance into an Identifiable
assert p instanceof Identifiable //	the target is an instance of Identifiable
assert !(p instanceof User) //	the target is not an instance of User anymore



//The diamond operator (<>) is a syntactic sugar only operator added to support compatibility with the operator of the same name in Java 7.

List<String> strings = new LinkedList<>()


//CALL OPERATOR
//The call operator () is used to call a method named call implicitly. For any object which defines a call method,
// you can omit the .call part and use the call operator instead

class MyCallable{
    int call(int x) { //MyCallable defines a method named call. Note that it doesn’t need to implement java.util.concurrent.Callable
        2*x
    }
}

def mc = new MyCallable()
assert  mc.call(2) == 4 //	we can call the method using the classic method call syntax
assert mc(2) == 4 // or we can omit .call thanks to the call operator









