package lectures7

def file = new File('test1.txt')
def cont = file.text
if (cont.contains('23-10-15'))
    println 'Number found'

def lines = file.readLines()
println 'There are ' + lines.size() + ' lines.'
lines.eachWithIndex { line, i ->
    println "${i+1} $line"
}

println 'List of lines starting with "J"'
jlist = []
file.eachLine { if (it.startsWith('J')) jlist << it }
println jlist


