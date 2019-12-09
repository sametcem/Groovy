package lectures1_6

//Collapsing of closures - currying

// Groovy release notes
// left currying
def multiply = { a, b -> a * b }
def doubler = multiply.curry(5)
println doubler(10)

def subtractl = {a, b -> a - b}
def dsub = subtractl.curry(5)
println dsub(7)

def subtract2 = {a,b -> a - b}
def dsub2 = subtract2.rcurry(5)
println dsub2(7)

// right currying
def divide = { a, b -> a / b }
def halver = divide.rcurry(5)
println halver(20)

// currying n-th parameter
def joinWithSeparator = { one, sep, two ->
    one + sep + two
}
def joinWithComma = joinWithSeparator.ncurry(1 ,',,, ')
println joinWithComma('a', 'b')

def joinWithComma2 = joinWithSeparator.ncurry(2, ',,,')
println joinWithComma2('a','b')