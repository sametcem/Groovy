package lectures1_6

//Memoization

/*
The return values for a given set of Closure parameter values are kept in a cache, for those memoized Closures.
That way, if you have an expensive computation to make that takes seconds, you can put the return value in cache,
so that the next execution with the same parameter will return the same result – again,
we assume results of an invocation are the same given the same set of parameter values.
 */

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
println 'Czas(Time) = ' + elapsed()/1000 + ' sek. The Calls: ' + count


fib = fib.memoize()
count = 0
startTimer()
println fib(34)
println 'Czas(Time) = ' + elapsed()/1000 + ' sek. The Calls: ' + count