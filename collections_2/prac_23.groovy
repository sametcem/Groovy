package collections_2

//Maksimum, minimum, sortowanie

def list = [ 100, 1, 20, 40, 5]
println list.max()
println list.min()

// sorts and returns the original (modified list)

list1 = list.sort()
println list
println list.is(list1) // czy list i list1 wskazuje na teb sam obiekt


// with the argument mutate == false
// creates a new, sorted list, doesn't change the original

list = [ 100, 1, 20, 40, 5]
list1 = list.sort(false)
println list
println list.is(list1) // czy list i list1 wskazuje na teb sam obiekt -> whether letter and letter 1 point to the same object

