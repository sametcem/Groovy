package lectures1_6

def tagIt = { data, tagKind ->
    "<$tagKind>$data<\\$tagKind>"
}
def bold = tagIt.rcurry('bold')
def italic = tagIt.rcurry('italic')
println bold("Kowalski") + italic("Jan")

println()

def fmoney = String.&format.curry('%.2f') // String.format(...)
def fdate = String.&format.curry('%tF') // zob. opis format w JDK
def dzis = new Date()
println 'Data zakupu ' + fdate(dzis) + ', koszt: ' + fmoney(3.21111)