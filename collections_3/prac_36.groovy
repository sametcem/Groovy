package collections_3

//Method get()

map = [a: 1, b: 2 ]
println map.get('a')
println map.getOrDefault('w', 'val for key w') // Java 8
println map.get('z', 'val for key z') //Groovy: added to the map!
println map
println map.z //the value from the previous get is already on the map

println("///")
//Method witDefault()

/*
The withDefault (Closure) method used on the map returns a new map
with the default values ​​set (for missing keys), determined by the closure code in which the key passed as the argument can be used.
*/


// Count the number of occurrences of words in the file
def map = [:].withDefault { 0 }
new File('tekst.txt').text.split( /[\s\p{Punct}]+/ ).each { map[it]++ }
map.each { println it }

println("/")
// And here the closure uses the key value
hash = [:].withDefault { key-> key.hashCode()}
println hash.a
println hash.A
println hash.Asia
println hash.Europe

println "/"
//Dot - universal accessory
// way to access values ​​in the "by key" map.

import groovy.transform.*
@Canonical //
        //   adds, among others tuple-constructor and toString
class Dog {
    def name
    def ill // czy jest chory?
}
def dog1 = new Dog('Barney', true)
def dog2 = [ name: 'Kuba', ill: true ]
cure(dog1, dog2)
println dog1
println dog2
def cure( ...dogs ) {
    dogs.each { it.ill = false }
}