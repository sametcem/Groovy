package collections_1

//Nuances of Removing Elements(1)

//The remove method (object) removes from any collection the first element that meets the condition elt.equals (object).

def col = [ 'a', 'b', 'a', 'c' ]
col.remove('a')
println col // modyfikuje oryginał -> modifies the original

col = [ 'a', 'b', 'a', 'c' ]
println col-'a' // zwraca nową kolekcję -> returns a new collection
println col

//(2)

col2 = [2, 3, 1]
println col2.remove(1) // 3
println col2