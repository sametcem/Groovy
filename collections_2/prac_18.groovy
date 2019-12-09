package collections_2

//Accessing to items by indexes

//Unlike Java, Groovy allows you to refer to (almost) any index values:

def list = ['a', 'b']
println list[100] // wartość null a nie wyjątek ArrayIndexOutOfBounds
println(list[-2])

