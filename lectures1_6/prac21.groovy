package lectures1_6

def list2 = []
def list3 = []
def other = []
(1..21).each { num ->
    switch(num) {
        case { it%2 == 0 } : list2 << num; break
        case { it%3 == 0 } : list3 << num; break
        default: other << num
    }
}
println "Multiple of 2: $list2"
println "Multiple of 3: $list3"
println "Other: $other"