package collections_3

/*
GroupBy ... methods applied to maps allow you to group entries into maps or lists of entries,
placing them under the key returned by the closure:
*/

map = [ Polska : 38, Czechy: 7, Węgry: 7,
        Hiszpania: 45, Chiny: 2000, Indie: 1000 ]
gmap = map.groupBy { k, v ->
    if (v < 10) 'small'
    else if (v < 100) 'medium'
    else 'big'
}
gmap.each { println it }


//Map sorting
// In Groovy, it is easy to sort maps

println "/"
res = map.sort {it.value.toInteger()}
println res.getClass()

es = res.entrySet() as List
//Large
es[-1..-3].each { println it}

println ("/")
// Small
es[0..3].each { println it}


