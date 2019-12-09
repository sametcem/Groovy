package collections_2

// Lists - using multiple indexes


def list = ['a', 'b', 'c', 'xxxxx' ]
println list[1..2] // inaczej: list.subList (1, 3)
println list[1..<2] // wyłączająco - inaczej: list.subList (1, 2)

// Odwracanie
println list[-1..0] // inaczej: list.reverse()


// Nadawanie wartości
list[1..2] = [ 'x', 'x']
println list

// Zamiast zakresów można stosowac dowolne kolekcje
idx = [0, 3]
println list[idx]

println list
list[idx] = ['x']*idx.size()
println list

