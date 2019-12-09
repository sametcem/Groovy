package files

//Data and objects
/*
In Java it is not uncommon to serialize and deserialize data using the java.io.DataOutputStream
and java.io.DataInputStream classes respectively. Groovy will make it even easier to deal with them.
For example, you could serialize data into a file and deserialize it using this code:
 */

boolean b = true
String message = 'Hello from Groovy'
def file = new File("C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\files\\test.txt")
// Serialize data into a file
file.withDataOutputStream { out ->
    out.writeBoolean(b)
    out.writeUTF(message)
}
// ...
// Then read it back
file.withDataInputStream { input ->
    assert input.readBoolean() == b
    assert input.readUTF() == message
}

//And similarily, if the data you want to serialize implements the Serializable interface,
// you can proceed with an object output stream

//(???)
Person p = new Person(name:'Bob', age:76)
// Serialize data into a file
file.withObjectOutputStream { out ->
    out.writeObject(p)
}
// ...
// Then read it back
file.withObjectInputStream { input ->
    def p2 = input.readObject()
    assert p2.name == p.name
    assert p2.age == p.age
}
