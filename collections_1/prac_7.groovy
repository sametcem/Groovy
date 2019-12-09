package collections_1

//Iterative objects

class CurrentWeek implements Iterable {
    def start= new Date(),
        end = start + 6,
        curr = start

    Iterator iterator() {
        [ hasNext: { curr <= end },
          next: { (curr++).format('dd') }
        ] as Iterator
    }

    def reset() { curr = start }
}


def cweek = new CurrentWeek()
cweek.each { print "$it "}
println()

cweek.reset()
cweek.eachWithIndex { e, i -> print "$i - $e " }
println()
cweek.reset()
for (d in cweek) print "$d "
println()
cweek.reset()
for (def d : cweek) print "$d "