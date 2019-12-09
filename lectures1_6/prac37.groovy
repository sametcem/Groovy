package lectures1_6

def pattern = /(dog|cat|cow)+/

println 'dogcat' ==~ pattern
println 'dogdogdog' ==~ pattern
println 'catcatcow' ==~ pattern


println("//")

def text = 'oops foo bar foo'
def patterna = ""

println 'Greedy: '
text.eachMatch('.*foo') {println it}

println 'Reluctant'
text.eachMatch('.*?foo') {println it}
