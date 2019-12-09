package lectures1_6

//Script Bindings

a = 1
b = 2 //  a and b added to bindings
func1()
println "$a $b"

def func1() {
    println "$a $b" // te same a i b - pobrane z bindings
    a = 10; b = 11;
}