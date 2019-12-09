package collections_1

//Iterative objects

// Various forms of iteration

def iter = {
    it.each { print "$it " }
    println()
    it.eachWithIndex { e, i -> print "$i - $e " }
    println()
    for (e in it) print "$e "
    println()
    for (def e : it) print "$e "
    println()
}

iter new File('firms.txt') // for text files - by lines
iter 'abcd' // for Strings - by characters
iter (1..7) //for ranges - by elements