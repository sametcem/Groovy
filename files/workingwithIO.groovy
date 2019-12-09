package files

//Reading Files
//let’s see how you would print all lines of a text file in Groovy:

def baseDir = "C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\files"
new File(baseDir, 'haiku.txt').eachLine { line ->
    println line
}
println("/")

new File(baseDir, 'haiku.txt').eachLine { line, nb ->
    println "Line $nb: $line"
}

/*
println("/")
def count = 0, MAXSIZE = 3
new File(baseDir,"haiku.txt").withReader { reader ->
    while (reader.readLine()) {
        if (++count > MAXSIZE) {
            throw new RuntimeException('Haiku should only have 3 verses')
        }
    }
}
*/
//to collect the lines of a text file into a list

def list = new File(baseDir, 'haiku.txt').collect {it}
println(list)

def array = new File(baseDir, 'haiku.txt') as String[]
println(array)

def file = "haiku.txt"
byte[] contents = file.bytes
println(contents)