package collections_3

//MAPS

//The map is a unique mapping of the key set into a set of values.

//Key values ​​cannot be repeated (the mapping must be unambiguous).
//However, the same values ​​can be saved under different keys (mapping does not have to be unambiguous).

/*
//Map Usability 1

import static javax.swing.JOptionPane.*

def map = [:].withDefault{'Invalid Firm Name'}
new File('firmsAddr.tsv').eachLine {
    //def (name, addr) = it.tokenize('\t')
    def tokens = it.tokenize("\t")
    def name = tokens[0]
    def addr = tokens[1]
    map[name] = addr
}
while (name = showInputDialog 'Enter firm name' ) {
    showMessageDialog null, "Firm: $name\nAddress: " + map[name]
}
*/


// Map Usability 2

import static javax.swing.JOptionPane.*
def dmap = new File('diagnose.tsv') // Przy okazji inny sposób
        .readLines() // budowy mapy z danych w pliku
        .collectEntries { it.tokenize('\t') }
while (sympt = showInputDialog 'Enter symptom' ) {
    showMessageDialog null, dmap[sympt] ?: 'n/a'
}