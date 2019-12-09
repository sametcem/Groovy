package collections_3

// ASK countries.tsv
def keynames = 'code    a   b   name    c   d   e   f   g'.split("\t")
def list = new File('TR.txt').readLines().collect {
    def map = [:]
    def data = it.split('\t')[0..keynames.size()-1]
    keynames.eachWithIndex { k, i -> map[k] = data[i] }
    map
}
println list.size() // ile mamy panstw-obszarow
// Jakie mamy oznaczenia kontynentow?
def cont = list.name as Set
println cont
// ile jest ludzi na świecie?
println list.f*.toBigDecimal().sum()