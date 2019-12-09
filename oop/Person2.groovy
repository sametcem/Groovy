package oop

class Persona {
    String name
    int age
}

def p = new Persona()
assert p.properties.keySet().containsAll(['name','age'])


