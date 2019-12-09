package lectures7

def file = new File('test3.txt')

def lines = ['aaa', 'bbb']
def cont = lines.join('\n')
file.text = cont // creating and writing
showFile file
file.append('\nccc') // appending
file.append(111) // can append any Object
showFile file
file << '\nxyz ' << [1, 7, 6]
showFile file
// overwriting
file.write('new content') // can write only String
showFile file
file.text = 'Again new content'
showFile file
def file2 = new File('out2.txt')
file2 << file.text // quick copy
showFile file2

def showFile(file) { println 'Now ' + file.name + ' content is:\n' + file.text }