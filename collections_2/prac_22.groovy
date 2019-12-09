package collections_2

data = new File('test2.txt').collect { it.tokenize('\t') }
years = data.remove(0)
selYearsInd = years*.toInteger().findIndexValues { it%5==0 }

data = data.collect { it[selYearsInd] }
out = [ years[selYearsInd].join('\t') ]
data.each { out << it.join('\t') }
println out.join('\n')

println("//")

// Prostsze rozwiązanie ->
//but requiring transposition twice
data2 = new File('test2.txt')
        .collect { it.tokenize('\t') }
        .transpose()
        .findAll { it[0].toInteger()%5 == 0 }
        .transpose()
        .collect { it.join('\t') }.join('\n')
println data2