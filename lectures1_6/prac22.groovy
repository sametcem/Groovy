package lectures1_6

// Closures: there is no global return

list = 'a b c d '.tokenize()
func1()
println "//"
func2()

def func1 () {
    list.each {
        if (it == 'b') return
        else println it
    }
}


// Workaround
def func2 () {
    try {
        list.each {
            if (it == 'b') throw new Exception()
            else println it
        }
    } catch(Exception exc) { return }
}