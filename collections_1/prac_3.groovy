package collections_1

//General operations on collections

def col // any collection

//Test closure

def op = { closure ->
    col = [1,2,3] // za każdym razem inicjujemy na nowo // each time we reinitiate
    closure() // wykonanie operacji // performing the operation
    println col // jak teraz wygląda // what it looks like now
    col // zwracamy ją do ew. wykorzystania // we return it for possible use
}

op { col << 100 } // 1 2 3 100
op { println col + 100 } // tworzy nową nie zmieniając oryginału
// 1 2 3 100
// 1 2 3
op { col += 100 }
// 1 2 3 100
op { col << [ 10,11, 12] }
// 1 2 3 10 11 12
op { println col*2 } // tworzy nową nie zmieniając oryginału
// 1 2 3 1 2 3
// 1 2 3
op { col *= 2 }
// 1 2 3 1 2 3
def newcol = op { col << 7 << 8 << 9 }
println newcol
// 1 2 3 7 8 9
// 1 2 3 7 8 9
def diff = newcol - [1, 7]
println diff
// 2 3 8 9