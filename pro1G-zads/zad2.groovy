//1
def maximum ( elements){
    def indList = [];
    elements.eachWithIndex{it,index->
        if(elements.max()==it)
        {indList.add(index)}
    }
    return [elements.max(),indList ]
}
(maxVal, indList) = maximum ([5, 3, 5, 5, 1, 5])
println "Maximum: $maxVal"
println "Indexes: $indList"
(maxVal, indList) = maximum (['a','c','c','c','b'])
println "Maximum: $maxVal"
println "Indexes: $indList"

/*
//2
import static javax.swing.JOptionPane.*
def getPhrase(){
    input = showInputDialog("Enter phrase")
    data = input.tokenize()
    println data
    println "Phrase contains ${data.size()} word(s)"
    println 'Enter line in console'
    input = new Scanner(System.in).nextLine()
    println input
}

def getInts() {
    input = showInputDialog("Enter 3 integers")
    scan = new Scanner(input)
    sum = scan.nextInt() + " " +  scan.nextInt() + " " +  scan.nextInt()
    showMessageDialog(null, "List: $sum")
}

getInts()


//3
def add = { x, y -> return x + y }
def mul = { x, y -> return x*y }
println add(1,5)
println add.call(1,5)
println op( 7, 8, add)
println op(7, 8, mul)

def op(x, y, closure) {
    return closure(x, y)
}

def pow = { x,y=2 -> println x**y }
pow 2

def list = [1,2,3]
list.each { print it }
println()
list.eachWithIndex { e, i -> list[i] *= 2 }
println list
def map = [x: 100, y: 200, w: 300, h: 500 ]
map.each { println it.key + ' ' + it.value }

*/
//4

import groovy.transform.Field

@Field
List transformed = []

List getData(Class type = String, Closure c = { it }) {
    String data = "42.58 1 3 4 555.55 0 ala ma kota"
    List l = data.tokenize(" ")

    l.eachWithIndex { it, index ->
        try {
            if (c.call(it.asType(type)))
                transformed.add(it)
        } catch (NumberFormatException e) {
            println(it + " not instanceof " + type)
        }
    }
    transformed
}

//spr
println getData(Integer) { it > 0 }            // liczby całkowite większe od 0
println getData(String) { it.size() > 3 }   // słowa o długości większej od 3 (domyślny typ: String)
println getData()                          // dowolne napisy (słowa)
println getData(BigDecimal)         // dowolne liczby


//5
def list = (1..40)

void eachTuple(list, Closure closure){
    if(list.getClass() == String){
        list.toList().collate(closure.maximumNumberOfParameters).each { closure it }
    }else{
        list.collate(closure.maximumNumberOfParameters).each { closure it }
    }
}

eachTuple(list) {e1, e2, e3, e4 -> println "$e1 $e2 $e3 $e4"}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s) {a, b -> out << b << a}
println out



//6
// In lecture, big factorial and long fibonacci series examples were given.


