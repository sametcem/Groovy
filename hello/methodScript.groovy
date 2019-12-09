package hello

//It is possible to define methods into a script, as illustrated here

int fib(int n) {
    n < 2 ? 1 : fib(n-1) + fib(n-2)
}
assert fib(10)==89

/*
You can also mix methods and code. The generated script class will carry all methods into the script class,
 and assemble all script bodies into the run method:
*/

println 'Hello' // 	script begins

int power(int n) { 2**n } // 	a method is defined within the script body

println "2^6==${power(6)}" //	and script continues



/*
This code is internally converted into:

import org.codehaus.groovy.runtime.InvokerHelper
class Main extends Script {
    int power(int n) { 2** n} //	the power method is copied as is into the generated script class
    def run() {
        println 'Hello' // 	first statement is copied into the run method
        println "2^6==${power(6)}" // second statement is copied into the run method
    }
    static void main(String[] args) {
        InvokerHelper.runScript(Main, args)
    }
}


//

Even if Groovy creates a class from your script, it is totally "transparent" for the user.
In particular, scripts are compiled to bytecode, and line numbers are preserved. This implies that if an exception is thrown in a script,
the stack trace will show line numbers corresponding to the original script, not the generated code that we have shown.

 */

//Variables in a script do not require a type definition. This means that this script:

// IT IS A LOCAL VARIABLE
int x = 1
int y = 2
assert x + y == 3

// will behave the same as:

// SCRIPT BINDING
x = 1
y = 2
assert x + y == 3


/*
However there is a semantic difference between the two:

if the variable is declared as in the first example, it is a "local variable."
It will be declared in the run method that the compiler will generate and will not be visible outside of the script main body.
In particular, such a variable will not be visible in other methods of the script

if the variable is undeclared, it goes into the script binding.
The binding is "visible" from the methods, and is especially important if you use a script to interact with
an application and need to share data between the script and the application. Readers might refer to
the integration guide for more information.

If you want a variable to become a field of the class without going into the Binding, you can use the @Field annotation.

 */