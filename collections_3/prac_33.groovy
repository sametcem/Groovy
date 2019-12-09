package collections_3

//Creating and initializing maps

/*
Empty map:

map = [:] // map is of type Map and LinkedHasMap
map = [:] as MapKlas // map is of the type MapKlas (e.g. HashMap or TreeMap)
 */

def show = {map ->
        map.each { k , v ->
            println "$k = $v / key type is: " + k.getClass()
        }
    }

map = [a : 1, b: 2]
show map

map = [1: 'a', 2: 'b']
show map

map = [1.1 : 'x' ]
show map

println("==================")

def func(n) { n*10 }

waw = 'Warszawa'
map = [Kraków: 'Małopolska', (waw) : 'Mazowsze',
       Mazowsze: waw, waw: 'Warszawa',
       'stolica Polski' : 'Warszawa',
       ('Miasto ' + waw) : 'Warszawa',
       (func(waw.size())) : waw.reverse() ]

map.each {println it}
