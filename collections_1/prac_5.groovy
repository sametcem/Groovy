package collections_1

//Iterating through any collections

def set = new HashSet()
def list = []

for (e in ['a','b','c', 'c']) set << e
set.each { list << it + '//added' }
println set
println list
