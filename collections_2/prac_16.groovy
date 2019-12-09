package collections_2

long start

def setTimer = { start = System.currentTimeMillis() }

def elapsed = { return System.currentTimeMillis() - start }

ArrayList aList = []

100000.times() { aList << 'a' }

LinkedList lList = new LinkedList(aList)

setTimer()
randomAccess(aList)
println "Direct access to ArrayList: " + elapsed() + " ms"
setTimer()
randomAccess(lList);
println "Direct access to LinkedList: " + elapsed() + " ms"
setTimer()
insert(aList)
System.out.println "Inserting in ArrayList: " + elapsed() + " ms"
setTimer()
insert(lList)
System.out.println "Inserting in LinkedList: " + elapsed() + " ms"


def randomAccess(List list) {
    Random rand = new Random();
    10.times {
        def index = rand.nextInt(list.size())
        def s = list[index]
        list[index] = s + 'a'
    }
}
void insert(List l) {
    ListIterator iter = l.listIterator() // has additional methods
    int i = 0
    while (iter.hasNext()) {
        iter.next();
        if (i % 2) iter.add('b');
        i++;
    }
}