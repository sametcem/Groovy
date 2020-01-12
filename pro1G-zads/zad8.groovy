//1
//The spread-dot operator (*.) is used to invoke an action on all items of an aggregate object.
/*
import static javax.swing.JOptionPane.*;
def inp = showInputDialog('Enter 3 numbers')
println inp
if (inp) {
    def list = inp.tokenize()
    println list.sum()
    def nums = list*.toDouble().collect()
    println nums
    println nums.sum()
    println oper(*nums)

}
def oper (a, b, c) {
    return a * (b + c)
}

 */

//2
def list = [1,-3,52,12,2]
print(list.sort())
println()
def llist = list.findAll(i -> i > 0)
print(llist)
println()
//3
def list1 = [1,-3,52,12,2]
def comp ={ a, b -> a == b ? 0 : a > b ? -1 : 1 }
        as Comparator
list1.sort(comp)
println(list1)

def list2 = [1,-3,52,12,2]
list2.sort(Comparator.reverseOrder())
println(list2)

def list3 = [1,-3,52,12,2]
Collections.sort(list3)
println(list3)
Comparator mc = { a, b -> a == b ? 0 : a > b ? -1 : 1 }
Collections.sort(list3, mc)
println(list3)

//4
def lista = [] // ArrayList by default
def set1 = [] as HashSet // unsorted set
def set2 = [] as TreeSet // sorted set
def set3 = [] as Set // LinkedHashSet (preserve insert order)

def lines = new File('companies.txt').readLines()
println lines
lines.each {
    lista << it.trim()
    set1 << it.trim()
    set2 << it.trim()
    set3 << it.trim()
}
println lista
println set1
println set2
println set3

println()

def lx = new File("color.txt").readLines()
println(lx)
def seta = [] as TreeSet
lx.each{
    seta << it.trim()
}
comp = { o1, o2 -> o1.size() - o2.size() } as Comparator
list1 = seta as List
list1.sort(comp)
println(list1)

println()
//5
def fruits = new File("countdown.txt").readLines()
println(fruits)
def list4 = []
fruits.each {
    list4 << it.trim()
}
list4.sort()
println(list4)
// special method count
println("Apple " + list4.count('Apple'))
println("Banana " + list4.count('Banana'))
println("Watermelon " + list4.count('Watermelon'))
println("Pineapple " + list4.count('Pineapple'))

//6 - Link is broken