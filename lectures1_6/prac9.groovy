package lectures1_6

vaf(1,2,5)
vaf('Dog', 10, 'Cat', 7)
def vaf( ... args) {
    s = args.size()
    println "Args num: $s"
    println 'First : ' + args[0]
    println 'Last : ' + args[s-1]
    for (a in args) {
        print a + ' '
    }
    println()
}


