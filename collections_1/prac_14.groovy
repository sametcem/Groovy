package collections_1

//withIndex method

def col = [ 100, 200, 300, 400, 500, 600 ]
// withIndex daje listę par [element, indeks]
def wi = col.withIndex()
println wi.getClass()
println wi
// otherwise we transform elements with good-looking indexes
println col.withIndex().collect { e, i -> i % 2 ? e/100 : e/10 }  // 0 1 2 3 4 5
// findAll będzie zwracać pary [element, indeks] spełniające podany warunek
println col.withIndex().findAll { e, i -> e > 300 }
println col.withIndex().findAll { e, i -> i > 2 }

println col.withIndex().findAll { e, i -> i < 2 ? e > 100 : e > 500 }


//Metoda inject
def taskNr = 2
def name = "Kowalski Jan Maria"
def nameWords = name.tokenize(' ')
def proj = nameWords.inject("Task$taskNr") { p, elt -> p +=elt[0]+elt[1] }
println proj

//Sumowanie
/*
Object sum()
Sums the items in a collection.

Object sum(Object initialValue)
Sums the items in a collection, adding the result to some initial value.

Object sum(Closure closure)
Sums the result of apply a closure to each item of a collection.

Object sum(Object initialValue, Closure closure)
Sums the result of apply a closure to each item of a collection to sum intial value.
 */

s1 =[1, 5, 7].sum()
s2 = [1, 5, 7].sum(10)
s3 = new File('bonus.txt').readLines().sum { it.size() }
println "$s1 $s2 $s3"

//Operator spread i spread-dot

/*
Spread === a(*list) a(list[0], list[1], ...)
Spread-dot === list*.a() [list[0].a(), list[1].a() ...]
 */

println("//")
import static javax.swing.JOptionPane.*;

def inp = showInputDialog('Enter 3 numbers')
println inp
if (inp) {
    def list = inp.tokenize()
    println list.sum()
    def nums = list*.toInteger()
    println nums.sum()
    println oper(*nums)
}
def oper (a, b, c) {
    return a * (b + c)
}