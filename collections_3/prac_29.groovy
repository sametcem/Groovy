package collections_3

//Map(4)

//JSON

import static javax.swing.JOptionPane.*
import groovy.json.JsonSlurper
def dmap = new JsonSlurper().parse(new File('diagnoses.json'))
while (sympt = showInputDialog 'Enter symptom' ) { showMessageDialog null, dmap[sympt] ?: 'n/a' }


/*
The JSON format is important because:
a) is used in web services
b) is used natively in JavaScript to represent objects
c) can also be used to record objects in languages ​​other than JS
d) is used in non-relational document databases

And from JSON formats we usually get maps and in the program,
with easy means of the Groovy language, we can flexibly operate on them.
*/


