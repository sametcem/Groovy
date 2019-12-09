package lectures1_6

//Annotation Memoized
/*
Converts the function to a closure and uses the memoize () method.
Easier, more natural code.
*/

import groovy.transform.*;

@Memoized
def fib(n) {
    if (n < 2) n
    else fib(n - 1) + fib(n - 2)
}

println fib(34) // result as before in milliseconds ready

