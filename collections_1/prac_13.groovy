package collections_1

// Filtering

/*
In methods

Collection findAll(Closure closure)
Finds all values matching the closure condition.

Collection grep(Object filter)
Iterates over every element of the collection and returns each item that matches
the given filter (filter as in 'case' label of 'switch' statement)


Other methods:
find {Closure} // returns the first element that meets the condition
boolean any {Closure} // is there an elt satisfying the condition
boolean every {Closure} // do all meet the condition
 */


def allFiles = []
def dir = new File('C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\collections_1')
dir.eachFileRecurse { if (it.isFile()) allFiles << it }
def groovyFiles = allFiles.findAll {
    it.name.endsWith('.groovy')
}
def smallFiles = allFiles.grep( { it.size() < 1000 } )
def smallFileNames = smallFiles.collect { it.name }
def txtFileNames = smallFileNames.grep( ~/.+\.txt/)
println 'Files in dirs of ' + dir.canonicalPath
println 'Is there any smaller than 100 ' + allFiles.any { it.size() < 100 }
println 'Is every file older than now ' +
        allFiles.every { it.lastModified() < new Date().time }
println 'All: ' + allFiles.size()
println 'Small: ' + smallFiles.size()
println 'Groovy: ' + groovyFiles.size()
println 'Small text files: ' + txtFileNames.size()
