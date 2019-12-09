package lectures1_6

rng = 1..10
sum = 0
for (x in rng) sum += x
println sum

list = [ 'a', 'b', 'c' ]
list1 = []
for (elt in list) list1 << elt + 'X'
println list1

for (x in [a:1, b:2, c: 3]) {
    println x
    println "$x.key $x.value"
}

low = 'a'
up = 'd'
for (c in up..<low) print c

napis = 'Warszawa'
println()
for (c in napis) print "-$c-"