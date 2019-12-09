package lectures7

import java.nio.charset.*

def f1 = new File('normalized.txt')
def f2 = new File('platform.txt')
def txt = 'a\nb\nc'
f1.text = txt
f2.text = txt.denormalize()
println 'Normal separator is: ' + '\n'.bytes // get its byte values
println 'Platform line separator is ' +
        System.getProperty('line.separator').bytes
println 'f1 byte cont is: ' + f1.text.bytes // get its byte values
println 'f2 byte cont is: ' + f2.text.bytes // get its byte values
def norm = f2.text.normalize()
println 'Normalized f2 byte cont: ' + norm.bytes

def chs = Charset.availableCharsets()
chs.each { println it.key + ' ' + it.value.aliases() }
