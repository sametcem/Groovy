package oop

class outer3 {
    private String privateStr = "some string"

    def startThread(){
        new Thread(new Inner2()).start()
    }

    class Inner2 implements Runnable{

        @Override
        void run() {
            println "${privateStr}."
        }
    }

    public static void main(String[] args) {
        def a = new outer3()
        a.startThread()
    }
}
