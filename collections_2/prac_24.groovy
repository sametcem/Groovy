package collections_2

// Porządek (ORDER)

/*
Natural Order
Natural order is determined by the definition of the "compareTo" method in the class. It has the following heading

public int compareTo (T otherObject)
where T is the type of the object,
and returns:

* number < 0 if this object is (in order) in front of the otherObject object,
* number> 0, if this object (this) is found (okay) after otherObject,
* 0 if the objects are the same.

 */


/*
COMPARATOR

The comparator is an object that compares other objects.
The comparators are implemented as class objects implementing the Comparator <T> interface,
where T is the type of objects being compared.

This interface contains an important method:

int compare(T o1, T o2)

In Groovy, interfaces with the compare method are implied as follows:

def comp = [ compare: { o1, o2 -> ... } ] as Comparator

comp: created object-comparator
compare : method name
{o1,o2 -> ...} : Closure
 */



/*
__Max, min and sort with comparators
In the max, min and sort methods, we can provide the argument of the previously created comparator or
just a closure, which is the comparator code:
 */

def list = [ "Red", 'Green', 'Blue' ]
println list.sort()
println list.sort { o1, o2 -> o1.size() - o2.size() }

// note using the sort method with a comparator
// means calling this method of the List interface from JDK (not GDK)
// and the result type is void, i.e. null is returned


list = [ "Red", 'Green', 'Blue' ]
println(list)
comp = { o1, o2 -> o1.size() - o2.size() } as Comparator
list.sort(comp)
println("/")
println list

// use the method to get a new list and not change the original
// from GDK: List sort (boolean mutate, Comparator comparator)








