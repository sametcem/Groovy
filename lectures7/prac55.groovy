package lectures7

long start
def startTimer = { start = System.currentTimeMillis() }
def elapsed = { System.currentTimeMillis() - start }

def n = 1000
File out = new File('forappend.txt')
out.text = ''
startTimer()
n.times { out << "Linia $it\n" }
println elapsed()
out.text = ''
startTimer()
out.withPrintWriter { writer ->
    n.times {
        writer.println "Linia $it"
    }
}
println elapsed()