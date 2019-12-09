package collections_3

/*
Note: The JsonBuilder class from groovy.json allows you to fix complex objects in JSON format

So we can save the contents of the object to a database or to a file in JSON or YAML format, and then restore it
*/

import org.yaml.snakeyaml.Yaml

class Studentx {
    def indNr
    def name
}
def s = new Studentx(indNr: 's0001', name: 'Abacki Adam')
def pmap = s.properties
pmap.remove('class') //we do not need information about the class
//Save to file in YAML format using the SnakeYAML library

def yaml = new Yaml()
def yfile = new File('stud.yaml')
yfile.text = yaml.dump(pmap)

def nmap = yaml.load(yfile.text)
println nmap

Student s2 = nmap
println s2.name

