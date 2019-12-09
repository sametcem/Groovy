package lectures7
import static javax.swing.JOptionPane.*;


//(?)
def file = new File('test1.txt')

def map = [:]
file.splitEachLine('\t') { tokens ->
    name = tokens[0].tokenize()
    map[name[1]+' '+name[0]] = tokens[1]
}


while ((inp = showInputDialog('Enter name')) != null) {
    name = inp.tokenize().join(' ')
    num = map[name] ?: 'Not found'
    showMessageDialog(null, "$name\n$num")
}