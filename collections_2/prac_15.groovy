package collections_2

//Lists , collections, arrays

//Efficieny Test - functions

//Pseudo-random number generator
def randomAccess(List list) {
    Random rand = new Random();
    10.times {
        def index = rand.nextInt(list.size())
        def s = list[index]
        list[index] = s + 'a'
        println(list[index])
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

List l = [1,2,3,4,5]
randomAccess(l);
println("/")
insert(l);