//1
/*
def list1 = [ 'a', 'b', 'c']
def list2 = [ 1, 8, 23 ]

list1.each {print(" $it")}
list2.each {print(" $it")}

println()

def list3 = []
list1.each {list3.add(it+it)}

println()

def list4 = []
list2.each {list4.add(it*it)}

list3.each {print(" $it")}
list4.each {print(" $it")}

*/

//2
def pmap = [Groovy: ['Asia', 'Jan'],
            Grails: ['Asia', 'Jan', 'Stefan', 'Mirek'],
            Java  : ['Asia', 'Stefan', 'Mirek'],
            JEE   : ['Slawek', 'Stefan', 'Janusz']
]

pmap.each { println("In project: $it.key has $it.value.size people") }

println()

println(pmap.findAll { it.value.size() > 2 })

println()

def out = [:]
pmap.each { set ->
    set.value.each { valueElemnet ->
        if (out.get(valueElemnet) == null) {
            def tmpValuesList = []
            tmpValuesList << (set.key)
            out.put(valueElemnet, tmpValuesList)
        } else {
            out.get(valueElemnet) << set.key
        }
    }
}

println(out)

//3
def txt = 'blakdlaskda 2019-03-12 asdasd 19/12/03 1997-13-12 1998-11-12adasdsd ' +
        '1998-01-32 1998-01-00 1998-01-31 1998-22-31'

txt.findAll(/(\d{4})-(\d{2})-(\d{2})/, { all, year, month, day ->
    def monthMatcher = month ==~ '[0][1-9]|[1][0-2]'
    def dayMatcher = day ==~ '[0-2][1-9]|[3][0-1]'
    def valid = false

    def month31 = month ==~ '01|03|05|07|08|10|12'

    if (month31 && (day.toInteger() <= 31))
        valid = true
    else if (!month31 && (day.toInteger() <= 30))
        valid = true

    if (monthMatcher && dayMatcher && valid)
        println "$all"
})

//4
import groovy.json.JsonSlurper

def txta = 'krzeslo 50 PLN komplet 2000.99 PLN tablet -1.11 PLN'
def regex = /([+-]?(?:\d+\.?\d*|\d*\.\d+)) PLN/

def urlString = 'https://api.exchangeratesapi.io/latest?base=EUR'
def apiResult = (new JsonSlurper()).parse(
        new InputStreamReader(
                (new URL(urlString)).newInputStream()
        )
)
def plnValue = apiResult.rates.PLN

txta = txta.replaceAll(regex) { all, price ->
    String.format("%.2f", price.toBigDecimal()/plnValue.toBigDecimal()) + ' EUR'
}

println txta

