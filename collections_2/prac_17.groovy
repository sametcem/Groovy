package collections_2

//Creating lists

// Direct initiation
def list = [1, 2, 3]  // ArrayList by default

// Direct initiation as LinkedList
list = ['a', 'b', 'c'] as LinkedList

// From the array
String[] stab = 'ala ma kota'.split()
println stab.toList()

// From any collection
def set = ['x', 'x', 'z'] as Set
println set.toList()

// Z napisu -> // From the string
println 'abcdefg'.toList()

// Z dowolnego Iteratora -> From any Iterator
def start = 1, end = 3, curr = 0
def niter = [hasNext: { curr < end }, next: { ++curr } ] as Iterator
println niter.toList()

// Z dowolnego Iterable
curr = 0
def numitb = { niter } as Iterable
println numitb.toList()