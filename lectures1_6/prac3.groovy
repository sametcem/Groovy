package lectures1_6

import static javax.swing.JOptionPane.*
map2 = [ Joan: '622-130-170', Steve: '677-190-278']

name = showInputDialog("Enter name:")
tel = map2[name]
showMessageDialog(null, "$name - tel. $tel")
