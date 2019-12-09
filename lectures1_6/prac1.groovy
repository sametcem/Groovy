package lectures1_6

import static javax.swing.JOptionPane.*
(kwota, ods) = showInputDialog('Podaj kwote i oprocentowanie').tokenize()
println "Kwota: $kwota"
println "Oprocentowanie: $ods"
kwota = kwota.toBigDecimal()
ods = ods.toBigDecimal()
println 'Po dodaniu odsetek kwota wynosi ' + (1+ods)*kwota