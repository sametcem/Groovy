package lectures1_6

//Key: tail recursion, i.e. the last operation in the function of self-calling or returning a result

counter = 0
factorial2 = { int n, def accu = 1G ->
    counter++
    if (n < 2) return accu
    factorial2.trampoline(n - 1, n * accu)
}

factorial2 = factorial2.trampoline()
BigDecimal fac1000 = factorial2(1000)
String s = fac1000.toString()
println 'Number of Calls: ' + counter
println 'Number of digits in the result: ' + s.size()
println s

