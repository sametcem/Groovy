package lectures7

//serialization (consolidation) of objects

def f = new File('o.ser')
def d = new Date()
def list = [1,2,3]

f.withObjectOutputStream {
    it.writeObject(d)
    it.writeObject(list)
}
olist = []
f.eachObject { olist << it }
println olist[0] == d &&
        olist[1] == list