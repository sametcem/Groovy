package collections_1

//Access to collections by indexes

def byIndx = { obj, i->
    println ''+obj.getClass() + " - indeks $i - " + obj[i]
}
def cols = [
        ['b', 'a', 'c', 'd'] as HashSet,
        ['b', 'a', 'c', 'd'] as Set,
        ['b', 'a', 'c', 'd'] as TreeSet
]
cols.each {byIndx it,0}
println('//')
cols.each { byIndx it, 1 }
println new CurrentWeek()[2]