package lectures1_6

import static javax.swing.JOptionPane.*;
name = showInputDialog('Enter name')
userName = name ? name : 'Anonymous' // ternary
println "User: $userName"
name = showInputDialog('Enter name') ?: 'Anonymous'
println "User: $name"