package lectures1_6

def list = [1,2,3]
list.each { print it }
println()

list.eachWithIndex { e, i -> list[i] *= 2 }
println list

def map = [x: 100, y: 200, w: 300, h: 500 ]
map.each { println it.key + ' ' + it.value }
map.each { k, v -> println "$k = $v" }
map.eachWithIndex { entry, i -> println "[$i] $entry" }
map.eachWithIndex { k, v, i -> println "($i) $k = $v" }

String s = 'Groovy'
def outList = []
s.each { outList << it }
println outList

(1..5).each { print it + ' ' }

def d1 = new Date(), d2 = d1 + 3
print '\n' + (d1.month+1) + ' /'
(d1..d2).each { print ' ' + it.date }