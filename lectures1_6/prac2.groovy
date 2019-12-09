package lectures1_6

import static javax.swing.JOptionPane.*
input = showInputDialog("Enter phrase")
data = input.tokenize()
println data
println "Phrase contains ${data.size()} word(s)"
println 'Enter line in console'
input = new Scanner(System.in).nextLine()
println input
input = showInputDialog("Enter 2 integers")
scan = new Scanner(input)
sum = scan.nextInt() + scan.nextInt()
showMessageDialog(null, "Sum: $sum")