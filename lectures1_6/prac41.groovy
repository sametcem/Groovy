package lectures1_6

def txt = 'Num 1 Number 200'
println txt
txt = txt.replaceFirst(/\w+\s+(\d+)\s+\w+\s+(\d+)/, 'Number [$2] Number ($1)')
println txt


println("/")
def txtt = 'NrInd801212345PESEL1233'
println txtt
txtt = txtt.replaceFirst(/([a-zA-Z]+?)(\d+?)([a-zA-Z]+?)(\d+?)/,
        '$3 $2 $1 $4')
println txtt