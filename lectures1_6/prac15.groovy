package lectures1_6

// (5) Groovy closures
// { [closureArguments->] statements }

def add = {x,y -> return x+y}
def mul ={x,y -> return x*y}

println add(1,5)
println add.call(1,5)

println op (7,8,add)
println op (7,8,mul)

def op(x,y,closure){
    return closure(x,y)
}

