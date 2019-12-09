package lectures1_6

def txt = ''
7.times {
    txt += "Groovy $it\n"
}
print txt

char c = 'A'
1.upto(10) { print c++ }
println()

def z = '*'
5.downto(1) {
    println z * it
}