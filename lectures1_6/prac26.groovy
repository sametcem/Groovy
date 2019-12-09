package lectures1_6

//Closure Composition
// from release notes
def plus2 = { it + 2 }
def times3 = { it * 3}

def times3plus2 = plus2 << times3 // operator << komponuje domknięcia
def plus2times3 = times3 << plus2

println times3plus2(2)
println plus2times3(2)
times3plus2 = times3 >> plus2 // można i w drugą stronę
println times3plus2(2)