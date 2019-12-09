package hello

// OPERATOR OVERLOADING
//Groovy allows you to overload the various operators so that they can be used with your own classes.

class Bucket {
    int size

    Bucket(int size) {
        this.size = size
    }

    Bucket plus(int capacity) {
        return new Bucket(this.size + capacity)
    }

    Bucket plus(Bucket other) { //Bucket implements a special method called plus()
        return new Bucket(this.size + other.size)
    }
}

//Just by implementing the plus() method, the Bucket class can now be used with the + operator like so:
def b1 = new Bucket(4)
def b2 = new Bucket(5)
assert (b1+b2).size == 9 // The two Bucket objects can be added together with the + operator
assert b1.size.plus(b2.size) == 9


/*
All (non-comparator) Groovy operators have a corresponding method that you can implement in your own classes.
The only requirements are that your method is public, has the correct name, and has the correct number of arguments.
The argument types depend on what types you want to support on the right hand side of the operator.

 */

assert (b1 + 11).size == 15