
//4
println "Please input the number to convert "
def input = System.in.newReader().readLine()
map1 = [1: 'jeden ', 2: 'dwa ', 3: 'trzy ', 4: 'cztery ',
        5: 'piec ', 6: 'szesc ', 7: 'siedem ', 8: 'osiem ', 9: 'dziewiec ']

def output = ''
for (item in input)
    output+=map1[item.toInteger()]

println(output.tokenize().join('-'))

//5
import static javax.swing.JOptionPane.showInputDialog
map = [:]
1.upto(3) {
    inputDialog = showInputDialog("Enter the product and its cost after spaces")
    scan = new Scanner(inputDialog)
    product = scan.next()
    price = scan.nextDouble()
    map.put(product,price)
}
println(map)
