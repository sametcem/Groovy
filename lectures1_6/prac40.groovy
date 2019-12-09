package lectures1_6

def txt = 'text with extra spaces within'
println txt
txt = txt.replaceAll(' +', ' x')
txt = txt.replaceFirst('with', 'with no')
println txt