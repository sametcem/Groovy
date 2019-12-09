package collections_3

//SPREAD MAP operator
// to us allows maps to replace the sequence of adding inputs from
// other maps to a given map by simple initiation.

def psykoty = [ psy: 2, koty: 3 ]
def owcekozy = [ owce: 1, kozy: 1]

// map of animals?
def zwierzaki = [ psykoty, owcekozy] //no! map list
println zwierzaki

//using the SPREAD MAP operator (* :) gives you a map!
zwierzaki = [ *:psykoty, *:owcekozy ]
println zwierzaki

println("/////")
//Adding << and + operators to maps

def map = [a: 1, b: 2]
def map1 = [c:3, d: 4]

println map + map1
println map
map << map1
println map
map += [x: 10, y: 20]
println map
def map2 = [kuba: 10, barney: 9]

// map << map2.entrySet () // it doesn't work
// but it is like this:

map2.entrySet().each { map << it }
println map