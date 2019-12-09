package lectures1_6

def db1 = {it*2}
def max = {x,y -> x > y ? x : y}
def p = {println it}
def c = { if (it > 10) return; it }

println db1(2)
println max(1,100)
p('Some text')
println c(11)
println c(7)

