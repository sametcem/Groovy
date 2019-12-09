package collections_2

// Useful list operations

//transpose () example


def data = []
new File('output-onlinerandomtools.txt').splitEachLine('\t') {
    data << it
}
data.each { println it.join('\t') }
println 'Transpozycja'
println("//")
data = data.transpose()
data.each { println it.join('\t') }



//List operations - index search

def list = ['x', 'aaa', 'abc', 'y']
println list.findIndexOf { it.startsWith('a') }
println list.findIndexValues { it.startsWith('a') }
println list.findIndexOf { it.size() == 1 }
println list.findIndexValues { it.size() == 1 }
list = [ 100, 1, 7, 21, 100, 51 ]
println list.findIndexValues { it in (20..100) }



