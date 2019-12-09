package lectures1_6

import groovy.transform.TailRecursive

// Annotation @TailRecursive

// przykład z http://mrhaki.blogspot.com
// rekurencyjne liczenie rozmiaru listy
@TailRecursive
def sizeOfList(list, counter = 0) {
    if (list.size() == 0) {
        counter
    } else {
        sizeOfList(list.tail(), counter + 1)
    }
}
println sizeOfList(1..10000) // 10000