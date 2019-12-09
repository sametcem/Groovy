package collections_3

map = [ Polska : 38, Czechy: 7, Węgry: 7,
        Hiszpania: 45, Chiny: 2000, Indie: 1000 ]
res = map.findAll { it.value < 10 } // zwraca LinkedHashMap
println res.getClass()
println res