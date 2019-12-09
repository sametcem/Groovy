package lectures7

def dir = new File('C:\\Users\\CEM\\IdeaProjects\\GroovyOOP\\src\\lectures7')
print '\n--- eachFile --- '
dir.eachFile { show(it) }
print '\n--- eachDir --- '
dir.eachDir { show(it) }
print '\n--- eachFileRec --- '
dir.eachFileRecurse { show(it) }
print '\n--- eachDirRec --- '
dir.eachDirRecurse { show(it) }
def show(f) {
    print '\n' + f.name
    if (f.isDirectory())
        print ' - dir'
}