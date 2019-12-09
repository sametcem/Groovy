package lectures1_6

// find with Closures

def res = 'abcdefgh 100 defgj'.find(/\d+/) { match->
    match.toInteger() + 11
}

println res

resx = 'ble kwota 100 PLN ble'.find(/(kwota)\s+(\d+)\s+PLN/) {
    match, word, num ->
        'amount ' + num.toBigDecimal()*4.1 + ' EUR'
}
println resx


// Przykład findAll z domknięciem

list = '''
1111 Jan
2222 Ania
3333 Stefan'''
list = list.findAll(/(?s)(\d\d\d\d)\s+?(\w+)/) { all, nr, name ->
    "s$nr@pjwstk.edu.pl <$name>"
}
list.each { println it }



//Pattern as a classifier in switch

def list = [1, -1, 100, '7', 'a', 2, 'x', 1.3 ]
def posInt = []
def other = []
list.each { e->
    switch(e) {
        case ~/\d+/ : posInt << e; break   // Pattern Object
        default: other << e
    }
}
println posInt
println other