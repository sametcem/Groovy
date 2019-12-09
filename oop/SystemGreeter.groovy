package oop

class SystemGreeter implements Greeter{
    @Override
    void greet(String name) {
        println "Hello $name"
    }

    public static void main(String[] args) {
        def greeter = new SystemGreeter()
        assert greeter instanceof Greeter
    }
}
