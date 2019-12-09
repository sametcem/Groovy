package collections_2

// Arrays

/*

Attention:
array initialization as in Java: int [] x = {1,2};
is unacceptable in Groovy. We need to use:
int [] x = [1, 2]
 */

//Accessing to table elements

/*
indexes - integers of type int from 0
number of elements in the array:
n = arr.length // Groovy and Java
n = arr.size () // Groovy


access to elements: arr [0], arr [1], ..., arr [n-1]
eg .:
def arr = new int [3]
arr [0] = 1
arr [1] = 2
arr [2] = 3
s = arr [1] + arr [2]
arr [0] = arr [0] * 2
*/

//Arrays and simple lists - an example


def arr = new String[2]
arr[0] = 'a'
arr[1] = 'b'
//arr << 'c' błąd - operator << nie dla tablic
//arr[2]='c' ArrayIndexOutOfBoundsException
println arr.class.name + ' ' + arr
println 'First: ' + arr[0]
println 'Last: ' + arr[arr.length-1]
println 'Last: ' + arr[arr.size()-1]
println 'Last: ' + arr[-1]

def list = []
list[0] = 'a'
list[1] = 'b'
list[2] = 'c'
println list.class.name + ' ' + list
println 'First: ' + list[0]
println 'Last: ' + list[list.size()-1]
//println 'Last: ' + list[list.length-1] błąd length nie dla list
println 'Last: ' + list[-1]
println list
list << 'c'
println list

println("/")
//List <-> array conversions

/*

Arrays can be converted into lists and vice versa:
arr = [1, 2, 3] as Integer [] // you can also as int []
list = ['a', 'b', 'c']
arr = list as String [] // you can also: arr = (String []) list
list = arr as List // the same effect as arr as ArrayList
list = arr.toList () // as above
 */

//Arrays and lists - identical operation

/*
Most of the discussed ways of accessing, iterating, searching, etc. can be used uniformly for arrays and lists.
*/

def listb = [1, 7, 15, 22 ]
def arrb = [1, 2 , 11, 17] as int[]
println listb.class.name + ' ' + arrb.class.name
sameSyntax listb
sameSyntax arrb

def sameSyntax(obj) {
    obj.each { print it + ' ' }
    println()
    println obj.findAll { it > 10 }
    println obj.inject(10) { sum, elt -> sum += elt } // inject is starting value i.e 10 or simply 0
}








