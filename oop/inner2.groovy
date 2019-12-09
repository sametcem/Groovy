package oop

//a inner class can access members of its enclosing class, even if they are private.
class Outer {
    private String privateStr

    def callInnerMethod(){
        new Inner().MethodA()  //	the inner class is instantiated and its method gets called
    }

    class Inner {   // 	inner class definition, inside its enclosing class
        def MethodA(){
            println "${privateStr}" // even being private, a field of the enclosing class is accessed by the inner class
        }
    }
}
