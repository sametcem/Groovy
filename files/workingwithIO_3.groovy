package files

//Traversing file trees
def currentDir = new File('C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\files')
currentDir.eachFile { file ->
    println file.name //executes the closure code on each file found in the directory
}
println("//")
currentDir.eachFileMatch(~/.*\.txt/) { file ->
    println file.name //	executes the closure code on files in the directory matching the specified pattern
}

println("//")
//Often you will have to deal with a deeper hierarchy of files, in which case you can use eachFileRecurse
def dir = new File("C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src")
dir.eachFileRecurse { file ->
    println file.name
}
/*
executes the closure code only on files, but recursively
dir.eachFileRecurse(FileType.FILES) { file ->
    println file.name
}
*/
println("//")

dir.traverse { file ->
    if (file.directory && file.name=='bin') {
        FileVisitResult.TERMINATE //if the current file is a directory and its name is bin, stop the traversal
    } else {
        println file.name
        FileVisitResult.CONTINUE //	otherwise print the file name and continue
    }

}
