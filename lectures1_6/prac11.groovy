package lectures1_6

rect char: 'o'
rect cols: 5, rows: 1
rect cols: 7, char: 'X'
def rect(amap) {
    if (!amap) println 'Invalid arg'
    def c = amap.char ?: '*'
    def n = amap.rows ?: 2
    def m = amap.cols ?: 2
    for (i in 1..n) {
        for (j in 1..m) print c
        println()
    }
}