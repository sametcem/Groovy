package lectures1_6

//Local Variables

/*
Variables entered with the type name or the word def are local variables,
visible only in the given block (and blocks contained in it).
 */

def c = 100
def d = 111
func2()
println "$c $d"
def func2() {

    def c = 77, d = 88
    println "$c $d"
}
