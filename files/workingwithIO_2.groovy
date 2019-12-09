package files

//Writing files

def baseDir = "C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\files"
new File(baseDir,'haiku.txt').withWriter('utf-8') { writer ->
    writer.writeLine 'Into the ancient pond'
    writer.writeLine 'A frog jumps'
    writer.writeLine 'Water’s sound!'
}

new File(baseDir,'haiku.txt') << '''Into the ancient pond
A frog jumps
Water’s sound!
Samet'''

/*
directly write bytes as in this example:
def file = "haiku.txt"
file.bytes = [66,22,11]
 */