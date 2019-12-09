package oop

//Varargs
//Groovy supports methods with a variable number of arguments.

def foo(Object ...args) { args.length }
assert foo() == 0
assert foo(1) == 1
assert foo(1,2,3) == 3

// Groovy allows T[] as a alternative notation to T…​. That means any method with an array as last parameter
// is seen by Groovy as a method that can take a variable number of arguments.

def foo2(Object[] args) { args.length }
assert foo2() == 0
assert foo2(1) == 1
assert foo2(1, 2) == 2

def foo3(Object... args2) { args2 }
assert foo3(null) == null

def foo4(Object... args) { args }

Integer[] ints = [1,2]
assert  foo4(ints) == [1,2]

// Another important point are varargs in combination with method overloading.

def foo5(Object... args) { 1 }
def foo5(Object x) { 2 }
assert foo5() == 1
assert foo5(1) == 2
assert foo5(1, 2) == 1


