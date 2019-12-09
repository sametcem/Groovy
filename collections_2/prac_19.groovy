package collections_2

//Lists - default values (1)

// The ability to reach for any indexes also implies being able to set the default value of the
// element when the index exceeds the list size.

def list = [90, 85].withDefault { 100 }
println list[3] // nieistniejący element uzyskał wart. 100 -> the non-existent element has received a value of 100
println list // ale lista zwiększyłą swoje rozmiary: -> but the list has increased in size
println list.size()

//Note that the "untouched" element is null.
//This is called lazy filling - the default value has only been given to one element.


//Lists - default values (2)

//The parameter of the withDefault method is closure. It gets the index and closure code as an argument,
// and can initialize non-existent elements on this basis:

def letters = [].withDefault { i-> 'A'*i }
println letters[5]
println letters
println letters.size()

//Laziness of initiation is a good option if initiation is expensive.
// But sometimes we want to have the right values instead of null.
// The withEagerDefault method is used for this:

def lista = [90, 85].withEagerDefault { 100 }
println lista[5]
println lista
println lista.size()