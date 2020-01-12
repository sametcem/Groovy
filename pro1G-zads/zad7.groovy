//1
def pmap = [  Groovy: [ 'Asia', 'Jan' ],
              Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
              Java: [ 'Asia',  'Mirek' ],
              JEE: [ 'Slawek', 'Stefan', 'Janusz' ]]

// How many people work in each project
pmap.each { k, v -> println "In  $k , ${v.size()} person works" }

def proj = new File('Projects.txt')
//Projects that have more than two programmers (3 p)
println 'Projects that have more than two programmers'
pmap.each { k, v -> if (v.size() > 3) proj.append(k) } // Only Grails

// Programmer Map
def prog = new File('Programmer.txt')
def prg = [:]  // key: programmer, value: project list

pmap.each { project, listProgrammer ->
    listProgrammer.each { programmer ->
        if (!prg[programmer]) prg[programmer] = []
        prg[programmer] << project
    }
}
prg.each {
    prog.append(it)
}

println(" ")


//2
println()
def txtb = '''Pierogi 25.5 PLN, Zupa 12.12 PLN, Woda 1 PLN,
Hamburger 22 PLN'''

def regexb = /(\d*\.?\d+)(\s+)PLN/

def rate = 4.3

txtb = txtb.replaceAll(regexb) { whole, number, space ->
    number = number.toBigDecimal()/rate
    return String.format("%.2f", number) + space + 'EUR'
}
/*
def menu = new File('Menu.txt')
menu.append(txtb)
*/

//3
def dir = new File('D:\\Cem-PJAIT\\LECTURES\\3. year\\5. semester\\Internet Technologies (TIN)\\TINTask6')
print '\n--- eachFile --- '
dir.eachFile { show(it) }
print '\n--- each HTML file --- '
//dir.eachFile { show(it.name.endsWith('.html'))}
def show(f) {
    print '\n' + f.name
    if (f.isDirectory())
        print ' - dir'
}

def list = []
def dir2 = new File("TestDir")
dir2.eachFileMatch( ~/\w+\.html/) {
     list << it.name
}
println()
println list


