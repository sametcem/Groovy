package lectures7

def dir = new File('C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\lectures7')
def list = []
dir.eachFileMatch( ~/\w+\.groovy/) {
    if (it.text.contains('[')) list << it.name
}
println list