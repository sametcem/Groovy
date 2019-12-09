package collections_3

//Map usability

/*
This allows you to easily write / read objects to / from files (e.g. in YAML or JSON format) and to / from document databases.
The getProperties () method returns a map with property values ​​under the key-names
 */

class Student {
    def indNr
    def name
}

def s = new Student(indNr: 's0001', name: 'Abacki Adam')
def pmap = s.properties
println pmap