package lectures1_6

// Trampoline

/*
„When writing recursive algorithms, you may be getting the infamous stack overflow exceptions,
 as the stack starts to have a too high depth of recursive calls. An approach that helps in those situations
 is by using Closures and their new trampoline capability.
 */

// Recursion without trampoline

// Funkcja z Groovy release notes
factorial1 = { int n, BigDecimal accu = 1 ->
    counter++
    if (n < 2) return accu
    factorial1(n - 1, n * accu)
}
counter = 0
try {
    def f = factorial1(1000)
    println f.toString().size()
    println f
} catch(Throwable exc) {
    println ''+exc
    println counter
}