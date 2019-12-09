package collections_1

//Collections from the collection

def lines = new File('firms.txt').readLines()
println lines
def set1 = new HashSet(lines)
def set2 = new LinkedHashSet(lines)
println set1
println set2

println '//'
// Mozna rownież tak (You can also do that)
set2 = lines as Set // to będzie LinkedHashSet ->this will be LinkedHashSet
def set3 = set1 as TreeSet
println set2
println set3