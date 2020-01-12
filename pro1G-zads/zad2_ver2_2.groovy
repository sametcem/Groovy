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
//println getData(Integer) { it > 0 }            // integers greater than 0
//println getData(String) { it.size() > 3 }   // words longer than 3 (default type: String)
//println getData()                          // any subtitles (words)
println getData(BigDecimal)         // any numbers

// 5

def eachTuple(def input, Closure c) {
    int paramsCount = c.getMaximumNumberOfParameters()
    List collatedList
    if (input instanceof String)
        collatedList = input.split("").collate(paramsCount)
    else
        collatedList = input.collate(paramsCount)

    collatedList.each { c.call(it) }
}

//spr
def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s) { a, b ->
    out << b << a
}
println out


import groovy.transform.TailRecursive

//trampoline and meomized - textbook examples of annotation
long start
def startTimer = { start = System.currentTimeMillis() }
def elapsed = { System.currentTimeMillis() - start }

//TCO
@TailRecursive
def factorial(n,res) {
    res *= n
    if (n == 1) {
        "Result: $res"
    } else {
        factorial(n - 1,res)
    }
}

startTimer()
def res = 1
println factorial(12,res)
println 'Czas = ' + elapsed()/1000

println()

//Normal factorial
def factorial2(n,res2) {
    res2 *= n
    if (n == 1) {
        "Result: $res2"
    } else {
        factorial(n - 1,res2)
    }
}

startTimer()
def res2 = 1
println factorial2(12,res2)
println 'Czas = ' + elapsed()/1000

/*
// Fibonacci
long start
long count = 0
def startTimer = { start = System.currentTimeMillis() }
def elapsed = { System.currentTimeMillis() - start }

fib = { n ->
    count++
    if (n < 2) n
    else fib(n - 1) + fib(n - 2)
}

startTimer()
println fib(34)
println 'Czas = ' + elapsed()/1000 + ' sek. Wolań: ' + count

println()

//Or: @Memoized
fib = fib.memoize()

count = 0
startTimer()
println fib(34)
println 'Czas = ' + elapsed()/1000 + ' sek. Wolań: ' + count
*/