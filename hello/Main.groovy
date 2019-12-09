package hello

//A script is always compiled into a class.
// The Groovy compiler will compile the class for you, with the body of the script copied into a run method.
// The previous example is therefore compiled as if it was the following:

import org.codehaus.groovy.runtime.InvokerHelper

class Main extends Script{ // 	The Main class extends the groovy.lang.Script class
    @Override
    Object run() { //groovy.lang.Script requires a run method returning a value
        println 'Welcome to the Groovy World!!!' // the script body goes into the run method
    }

    public static void main(String[] args) { //the main method is automatically generated
        InvokerHelper.runScript(Main,args); //and delegates the execution of the script on the run method

    }
}

/*

If the script is in a file, then the base name of the file is used to determine the name of the generated script class.
In this example, if the name of the file is Main.groovy, then the script class is going to be Main.

 */