package collections_2

// TreeSet - content and order

/*
The order is determined by the compareTo methods from the object class or compare comparator.
In the case of TreeSet they decide not only about the order
but also about the content (elements "the same" in order as already included in the set will not be added).
Therefore, compareTo methods in object classes,
as well as comparators used in the TreeSet (Comparator) constructor must clearly distinguish
between elements that are to be included in the set.
 */

def list = ['ala', 'x', 'kot', 'pies' ]
def set1 = list as TreeSet // porządek naturalny -> Natural Order
println set1

// porządek wg komparatora użytego w konstruktorze -> order according to the comparator used in the constructor
def set2 = new TreeSet( {a, b -> a.size() - b.size() } )
set2.addAll(list)
println set2 // straciliśmy kota! -> we lost the cat


// if we want to have sorted TreeSet content
// according to any comparator, use the sort () method, which is not
// change the contents of the file and return a sorted list

def list2 = set1.sort {a, b -> a.size() - b.size() }
println set1
println list2.getClass().simpleName
println list2