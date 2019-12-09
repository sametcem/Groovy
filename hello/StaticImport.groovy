package hello

import static java.lang.String.format //	static import of method

//Groovy’s static import capability allows you to reference imported classes as if they were static methods in your own class:
class StaticImport {

    String format(Integer i){ //	declaration of method with same name as method statically imported above, but with a different parameter type
        return i.toString();
    }

    public static void main(String[] args) {
        assert format('String') == 'String' //compile error in java, but is valid groovy code
        assert new StaticImport().format(Integer.valueOf(1)) == '1'
    }
}
