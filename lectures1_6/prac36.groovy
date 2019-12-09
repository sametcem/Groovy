package lectures1_6

//Matcher find() w Groovy

def text ='alabama'
def matcher = text =~'a.a'

println matcher.size()
println matcher[0]
println matcher[1]

println("/")
for (match in matcher) println match
println("/")

def res = []
matcher.each {res << it}
println res