/*
// with Generic
def maximum(list){
    output = []
    indexes = []
    objectsMap = [:]
    list.eachWithIndex { it, index ->
        if(!objectsMap.containsKey(it)){
            indexes.add(index)
            objectsMap.put(it,indexes)
            indexes = []
        }else{
            List listTmp = objectsMap.get(it)
            listTmp.add(index)
            objectsMap.put(it,listTmp)
        }
    }
    objectsMap = objectsMap.sort {it.value}
    output.add(objectsMap.entrySet().last().key)
    output.add(objectsMap.entrySet().last().value)
    return output
}

(maxVal, indList) = maximum( [5, 3, 5, 5, 1, 5] )
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"

//2
import static javax.swing.JOptionPane.showInputDialog

List getInts() {
    list = []
    1.upto(3) {
        inputDialog = showInputDialog("Enter the total number")
        scan = new Scanner(inputDialog)
        list.add(scan.nextInt())
    }
    //List<Integer> output = list.collect { it -> Integer.parseInt(it) }
    return list
}
println getInts()
*/
//3
import groovy.transform.Field
import groovy.transform.TailRecursive

@Field
List transformed = []

@TailRecursive
List apply(List l, Closure c) {
    if (l.size() == 0) {
        println transformed
    } else {
        transformed.add((c.call(l.get(0))))
        apply(l.tail(), c)
    }
}

//spr
apply([1, 2, 3, 4, 5, 6]) { it + 2 }

transformed = []
List l2 = ['a', 'b', 'c', 'd', 'e', 'f']
apply(l2) { it + 2 }

transformed = []
List l3 = ["Ala", "ma", "kota"]
def c3 = { it.size() > 3 }
apply(l3, c3)


