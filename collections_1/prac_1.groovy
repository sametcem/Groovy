package collections_1

//Collections and iterable objects

def list = [] // ArrayList by default
def set1 = [] as HashSet // unsorted set
def set2 = [] as TreeSet // sorted set
def set3 = [] as Set // LinkedHashSet (preserve insert order)


def lines = new File('firms.txt').readLines()
println lines

lines.each {
    list << it.trim()
    set1 << it.trim()
    set2 << it.trim()
    set3 << it.trim()
}

println('ArrayList')
println list
println('HashSet')
println set1
println('SortedSet')
println set2
println('Set (LinkedHashSet)')
println set3