package collections_3

//Access to values under the keys
//Three options: dot, index or get ()


def map = [a:1, 'chg commited':2, 1: 'a', 2: 'b']
def var = 'a'

// Use a dot - only a String key after the dot

println map.a
println map.'chg commited'
println map.var //there is no value under the 'var' key

map.a = 100
map.'chg commited' = 3
println map

//Use indexing - index is any expression that gives the keyq value
println("/")
def a = 1
println map[a] //variable a (has the value 1 and this will be the key)
println map['a'] // the literal 'a' is the key
println map[var]  //the key will be the value of the var variable
println map[1] //integer - key
map[a+1] = 100
println map