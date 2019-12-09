package lectures1_6

//currying + composition
def tagIt = { data, tagKind ->
    "<$tagKind>$data<\\$tagKind>"
}
def bold = tagIt.rcurry('bold')
def italic = tagIt.rcurry('italic')
def bi = italic >> bold
println bi("Kowalski Jan")

println()

def discount = 0.1
def rate = 0.2
def multiply = { x, y -> x * y }

def priceWithTax = multiply.curry(1 + rate)

def priceWithDiscount = multiply.curry(1 - discount)

def netPrice = priceWithDiscount << priceWithTax
println netPrice(100) // wynik: 108.00