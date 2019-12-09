package collections_1

//Collective operations

//adding array elements - addAll (Object [])
//adding elements of any Iterable - addAll (Iterator)
//removing elements contained in an array - removeAll (Object [])
//removing / leaving elements satisfying a condition: removeAll (Closure), retainAll (Closure)
//intersect - the common part (the sum is provided by +)
//unique (for Iterable - toUnique) - removing duplicates
//toSet, toList etc.,
//flatten - flattening the collection.


// CONDITIONAL DELETE
def col = [ "Cypr - wyspa",
            "Madagaskar - wyspa",
            "Krabi",
            "Londyn"]

col.removeAll { !it.contains('wyspa') }
println col

col = [ "Cypr - wyspa",
            "Madagaskar - wyspa",
            "Krabi",
            "Londyn"]
// YOU CAN ALSO DO THIS
col.retainAll { it.endsWith('wyspa') }
println col

col = [ "Cypr - wyspa",
        "Madagaskar - wyspa",
        "Krabi",
        "Londyn"]

// Or also you can do
// metody removeIf z Javy 8
col.removeIf { !it.endsWith('wyspa') }
println col
/*
Note: all of the above methods modify the original collection.
To get a new collection with deleted items without changing the original,
 you can use the findAll () method.
 */