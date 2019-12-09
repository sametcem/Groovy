package oop

class Person1 {
    String name
    void name(String name){
        this.name = "Wonder$name"
    }

    String wonder(){
        this.name
    }

     static void main(String[] args) {
        def p = new Person1()
        p.name = 'Merge'
        println(p.wonder())
        p.name('Selen')
        println(p.wonder())
    }
}
