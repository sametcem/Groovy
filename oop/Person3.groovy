package oop

class PseudoProperties{
    // a pseudo property "name"
    void setName(String name) {}
    String getName(){}

    // a pseudo read-only property "age"
    int getAge() { 42 }

    // a pseudo write-only property "groovy"
    void setGroovy(boolean groovy) {  }
}

def p = new PseudoProperties()
p.name = 'Foo' //writing p.name is allowed because there is a pseudo-property name
assert p.age == 42 //reading p.age is allowed because there is a pseudo-readonly property age
p.groovy = true // writing p.groovy is allowed because there is a pseudo-writeonly property groovy

