package lectures7

def fnames = ['c:/ppp/ppp', '.',
              'test1.txt', 'src']
fnames.each { showProps(it) }
def showProps(fname) {
    println "Passed filename is: $fname"
    def f = new File(fname)
    println f.name
    println f.path
    println f.absolutePath
    println f.canonicalPath
    if (f.exists()) {
        println f.isDirectory()
        println f.size()
        println f.lastModified()
    }
    else println "File doesn't exists"
}