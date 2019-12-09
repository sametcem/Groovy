package lectures7

//Reading text files

def file = new File('text.txt')
def cont = file.getText()

//Load the entire file at once
def cont2 = file.text // Shortcut

// Obtaining a list of poems
def lineList = file.readLines()

//Line by line processing in a closure
file.eachLine { line -> println(line) }

//Line cutting processing
file.splitEachLine(sep) { tokenListInLine ->  }