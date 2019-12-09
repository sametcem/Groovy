package lectures1_6

rect()
rect('A')
rect('x',3,3)

def rect(c='*', n=2, m=2) {
    for (i in 1..n) {
        for (j in 1..m) {
            print c
        }
        println()
    }
}