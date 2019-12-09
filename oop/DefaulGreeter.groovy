package oop

class DefaulGreeter implements ExtendedGreeter {
    void greet(String name) {println "Hello"}

    public static void main(String[] args) {
        def greeter = new DefaulGreeter()
        assert (greeter instanceof Greeter)

        def coerced = greeter as Greeter
        assert coerced instanceof Greeter
        greeter.sayBye()
    }

    @Override
    void sayBye(String name) {
        println "Bye"
    }
}
