package hello

/*
LISTS
Groovy uses a comma-separated list of values, surrounded by square brackets, to denote lists.
 */

def numbers = [1, 2, 3]

assert numbers instanceof List
assert numbers.size() == 3

def heterogeneous = [1, "a", true]   // 	Our list here contains a number, a string and a boolean value
//We mentioned that by default, list literals are actually instances of java.util.ArrayList


//thanks to using type coercion with the as operator, or with explicit type declaration for your variables:

def arrayList = [1, 2, 3]
assert arrayList instanceof java.util.ArrayList

def linkedList = [2, 3, 4] as LinkedList
assert linkedList instanceof java.util.LinkedList

LinkedList otherLinked = [3, 4, 5]
assert otherLinked instanceof java.util.LinkedList

/*
You can access elements of the list with the [] subscript operator (both for reading and setting values)
with positive indices or negative indices to access elements from the end of the list, as well as with ranges,
and use the << leftShift operator to append elements to a list:
 */

def letters = ['a', 'b', 'c', 'd']

assert letters[0] == 'a'
assert letters[1] == 'b'

assert letters[-1] == 'd' //Access the last element of the list with a negative index: -1 is the first element from the end of the list
assert letters[-2] == 'c'

println(letters)

letters[2] = 'C'
assert letters[2] == 'C'

letters << 'e'
assert letters[ 4] == 'e'
assert letters[-1] == 'e'

println(letters)

assert letters[1, 3] == ['b', 'd']
assert letters[2..4] == ['C', 'd', 'e']


//Access the second element of the top-most list, and the first element of the inner list (2D)
def multi = [[0, 1], [2, 3]]
assert multi[1][0] == 2

// ARRAYS

String[] arrStr = ['Ananas', 'Banana', 'Kiwi']

assert arrStr instanceof String[] // 	Assert that we created an array of strings
assert !(arrStr instanceof List)

def numArr = [1, 2, 3] as int[] // 	Create an array of ints with the as operator

assert numArr instanceof int[]
assert numArr.size() == 3

//You can also create multi-dimensional arrays:

def matrix3 = new Integer[3][3] // 	You can define the bounds of a new array
assert matrix3.size() == 3

Integer[][] matrix2 // Or declare an array without specifying its bounds
matrix2 = [[1, 2], [3, 4]]
assert matrix2 instanceof Integer[][]


String[] names = ['Cédric', 'Guillaume', 'Jochen', 'Paul']
assert names[0] == 'Cédric'

names[2] = 'Blackdrag' // Set the value of the third element of the array to a new value
assert names[2] == 'Blackdrag'

// MAPS
//Sometimes called dictionaries or associative arrays in other languages, Groovy features maps.
// Maps associate keys to values, separating keys and values with colons,
// each key/value pairs with commas, and the whole keys and values surrounded by square brackets.

def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

assert colors['red'] == '#FF0000'
assert colors.green  == '#00FF00'

colors['pink'] = '#FF00FF'
colors.yellow  = '#FFFF00'

assert colors.pink == '#FF00FF'
assert colors['yellow'] == '#FFFF00'

assert colors instanceof java.util.LinkedHashMap
println(colors)

assert colors.black == null // If you try to access a key which is not present in the map: -> You will retrieve a null result.

def numbersx = [1: 'one', 2: 'two']

assert numbersx[1]== 'one'
assert numbersx[2]== "two"
assert numbersx[3] == null
println(numbersx)

// Groovy will not create a string key like in our previous examples.

def key = 'name'
def person = [key: 'Guillaume'] // The key associated with the 'Guillaume' name will actually be the "key" string, not the value associated with the key variable

assert !person.containsKey('name') // The map doesn’t contain the 'name' key
assert person.containsKey('key') // 	Instead, the map contains a 'key' key

// You can also pass quoted strings as well as keys: ["name": "Guillaume"].
// When you need to pass variable values as keys in your map definitions, you must surround the variable or expression with parentheses

person = [(key): 'Guillaume'] // 	This time, we surround the key variable with parentheses, to instruct the parser we are passing a variable rather than defining a string key

assert person.containsKey('name') // 	The map does contain the name key
assert !person.containsKey('key') //   But the map doesn’t contain the key key as before
println(person)