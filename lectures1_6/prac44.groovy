package lectures1_6

//Przykłady find i findAll

// find the first string of numbers in the text

println 'xyz'.find(/\d+/)
println 'abcdefgh 100 defgj'.find(/\d+/)

//// find all the number strings in the text

def list = 'a 1 b 2 c9 x110'.findAll(/\d+/)
println list