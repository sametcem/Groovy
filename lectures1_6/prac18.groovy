package lectures1_6

//Passing closures to functions

def x = 0
def incr = { x++ }
op(3, incr)
println x
op(3, { x++ } )
println x
op(3) { x++ }
println x
def op(n, closure) {
    for(i in 1..<n) closure()
    return closure()
}

println("//")

def xx = 0
def incrx = {xx++}
println xx

xx = 10
println xx
incrx()
println xx