//1

def list1 = ['a', 'b', 'c']
def list2 = [1, 8, 23]

list1.each {print it + " "}
println()
list2.each {print it + " "}
println()

def list11 = list1.each {print it+it + " "}
println()
def list22 = list2.eachWithIndex { e, i -> list2[i] *= 2 }
println list22

//2
def pmap = [  Groovy: [ 'Asia', 'Jan' ],
              Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
              Java: [ 'Asia',  'Mirek' ],
              JEE: [ 'Slawek', 'Stefan', 'Janusz' ]]

// How many people work in each project
pmap.each { k, v -> println "In  $k , ${v.size()} person works" }

//Projects that have more than two programmers (3 p)
println 'Projects that have more than two programmers'
pmap.each { k, v -> if (v.size() > 2) println k }
println()

//What projects do the individual programmers participate in?

// Programmer Map
def prg = [:]  // key: programmer, value: project list

pmap.each { project, listProgrammer ->
    listProgrammer.each { programmer ->
        if (!prg[programmer]) prg[programmer] = []
        prg[programmer] << project
    }
}
prg.each {
    println it.key + ' - ' + it.value
}

println(" ")

// 3
// text in which we search for dates


def txt = '''2007-01-12Jakis txt2008-01-31 xxx 2008-02-29 2008-15-10 2008-19-45 2009-05-01 
20999-11-11 pppp 2001-00-01 09-01-01 2001-01-00 2009-01-111 2009-02-29 1998-11-11'''

def correctDates = []
def regex = /(?:^|\D)((\d\d\d\d)-(\d\d)-(\d{2,}))/

txt.eachMatch(regex) { wholeMatch, wholeDate, year, month, day ->
    if ((year+month+day).size() != 8) return   // too many digits in days - goes to next match
    year = year.toInteger()
    month = month.toInteger()
    day = day.toInteger()

    // we can only resist checking on
    // we can only check / because daysInMonth () returns 0 for the wrong month of the day,
    if (day != 0 && day <= daysInMonth(year, month))
        correctDates << wholeDate
}

println correctDates
// here the program ends Today the function defines the number of days in the month
def daysInMonth(year, month) {
    switch(month) {
        case 2 : return isLeapYear(year) ? 29 : 28    // FEBRUARY
        case 1..7  : return month%2 ? 31 : 30  // JULY
        case 8..12 : return month%2 ? 30 : 31  // to July from August to December
        default: return 0  // DEFECTIVE MONTH
    }
}

// Is this year a lap year?
def isLeapYear(year) {
    if (year % 4 == 0) {
        if (year > 1582) return year%100 != 0 || year%400 == 0
        else return true
    }
    return false
}

//4
def txta = '''2007-01-12Jakis txt2008-01-31 xxx 2008-02-29 2008-15-10 2008-19-45 2009-05-01 
20999-11-11 pppp 2001-00-01 09-01-01 2001-01-00 2009-01-111 2009-02-29 1998-11-11'''

def correctDatesa = []
def regexa = /(?:^|\D)((\d\d\d\d)-(\d\d)-(\d{2,}))/
def matchera = (txta =~ regexa)
matchera.each {
    (year, month, day) = it[2..-1]*.toInteger()
    if (!(month in 1..12) || !(day in 1..31)) return
    Calendar date = Calendar.instance
    date.set(year, month-1, 1)
    if (day > date.getActualMaximum(Calendar.DAY_OF_MONTH)) return
    correctDates << it[1]
}
println correctDates

//5 Converting Currency
println()
def txtb = '''Wydano 75.5 PLN, po czym znaleziono 123.12 PLN, i tez .1 PLN,
przekazano do banku 225 PLN, 33 PLN, 400 PLN oraz 77 EUR'''

def regexb = /(\d*\.?\d+)(\s+)PLN/

def rate = 4.3

txtb = txtb.replaceAll(regexb) { whole, number, space ->
    number = number.toBigDecimal()/rate
    return String.format("%.2f", number) + space + 'EUR'
}

println txtb






