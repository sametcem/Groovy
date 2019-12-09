package lectures1_6

def txt = 'London 1957 Warsaw 2009'
def regex = /(\w+)\s+(\d+)/
def matcher = txt =~ regex

println matcher[0][0]
println matcher[0][1]
println matcher[0][2]
println matcher[1][0]
println matcher[1][1]
println matcher[1][2]

println("/")
def map = [:]
txt.eachMatch(regex) { all, town, date ->
    map[town] = date
}
map.each { println it.key + ' - ' + it.value }