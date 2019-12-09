package lectures1_6

def ok = {println 'Ok'}
def p = {println it}
def pow = {x,y=2 -> println x**y}

def sum = { ... num ->
    sum = 0
    for (n in num) sum += n
    println sum
}

def info = {
    map -> for (en in map) println "${en.key}: ${en.value}"
}

ok()
p 'Groovy'
pow 2
pow 2,4
sum 1,2,3
sum 10,11
info Language:'Grooovy', version: '1,7'


