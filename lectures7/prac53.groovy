package lectures7

//Saving Binary Data

def file = new File('data.bin')
def ints = [1, 2, 3]

file.withDataOutputStream { dos ->
    dos.writeInt(ints.size())
    ints.each { dos.writeInt(it) }
}

def bytes = []
file.eachByte { bytes << it }
println bytes

def sum = 0
file.withDataInputStream { dis ->
    n = dis.readInt()
    n.times {
        sum += dis.readInt() }
}
println sum