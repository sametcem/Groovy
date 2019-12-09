package lectures7

def f = new File('test2.txt')
lines = f.collect { it.replace('\\', '/') }
lines.each { println it }