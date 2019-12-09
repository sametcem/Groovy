package collections_1

//Flattening the collection // DUZLESTIRMEK

/*
The useful flatten () method, generally applicable to any Iterable,
flattens the data set (which may contain other sets as elements). Example:
*/


def col1 = [1, 2, 3]
def col2 = [7, 8, 9]
col2 << [10, 11, 12]
col1 << col2
println col1
col1 = col1.flatten()
println col1

println("//")

//Filter-map-reduce operations can be used on any iterable object

/*
In Groovy we have, among others the following methods:
filter === findAll
map === collect
reduce === inject (+ various simple reductions
+ container reductions)
 */





//Metoda collect -> List list = coll.collect { closure }

//Iterates through this collection transforming each entry into a new value using the
// closure as a transformer, returning a list of transformed values.


def defaultBonus = 100
def f = new File('bonus.txt')
println f.text

def bonus = f.readLines().collect {
    if (it.tokenize().size() < 2) "$it $defaultBonus"
    else it
}
println 'Default bonus assigned'
bonus.each { println it }

