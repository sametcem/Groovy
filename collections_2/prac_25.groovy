package collections_2

import org.apache.tools.ant.taskdefs.Local

//Special Comparators

//Inverted natural order is easily obtained by Comparator.reverseOrder ():

def list = [ 'Red', 'Blue', 'Green' ]
list.sort(Comparator.reverseOrder())
println list // [Red, Green, Blue]

/*
orting according to the rules of a given language zone requires
the use of an appropriate collator instance (package java.text). Example:
*/

// COLLATOR
import java.text.Collator
list = ["cedr", "ćwiek", "list", "łopata" ]
println list.sort() // bez kolatora
// Kolator dla języka polskiego
def comp = Collator.getInstance(new Locale('pl'))
// kolatory są komparatorami
println (comp instanceof Comparator)
list.sort(comp)
println list

println("/")

def list2 = ["samet","şevval","çağrı","cem"]
def comp2 = Collator.getInstance(new Locale('tr'));
println (comp2 instanceof Comparator)
list2.sort(comp2)
println(list2)

