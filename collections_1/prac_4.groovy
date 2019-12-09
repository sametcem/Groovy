package collections_1

// Iterator

def set = [1, 2, 8, 8, 17, 9] as Set
println set

def iter = set.iterator()
while (iter.hasNext()) {
    elt = iter.next()
    println elt
    if (elt < 7) iter.remove()
}
println set

//"Concurrent modification" not allowed

/*
During iteration using an iterator, it is not allowed to modify the collection
by other means than using the methods of this iterator (e.g. remove).
Let c - any collection

Iterator it1 = c.iterator()
while (it1.hasNext()) {
it1.next()
l.add('x') // Błąd fazy wykonania -> Runtime Error
}


Iterator it1 = c.iterator();
Iterator it2 = c.iterator();
while (it1.hasNext()) {
it1.next();
it2.next();
it2.remove(); // Błąd fazy wykonania
}

These are ConcurrentModificationException
 */