package lectures1_6

//Code execution when replacing

def txt = 'krzeslo 50 PLN komplet 2000 PLN'
println txt
txt = txt.replaceAll(/(\d+) PLN/) { all, kwota->
    String.format("%.2f", kwota.toBigDecimal()/4.12) + ' EUR'
}
println txt