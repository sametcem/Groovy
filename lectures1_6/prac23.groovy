package lectures1_6

//Transforming functions into closures
//[def] var = &func_name

def function(arg) {
    println arg
}
def f = this.&function
f('A')

def sysprop = System.&getProperty // getProperty(String) klasy System
println sysprop('file.separator')

