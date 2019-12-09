package hello

println "hello world!"
println 1 /* one */ + 2 /* two */
assert 'ab' == 'a' + 'b' // concat
println 'The Euro currency symbol: \u20AC'

// Identifiers start with a letter, a dollar or an underscore. They cannot start with a number.
def $dollarstart = 2
def _withunderscore = 3
println($dollarstart + _withunderscore)

def map = [:]
map."an identifier with a space and double quotes" = "ALLOWED"
map.'with-dash-signs-and-single-quotes' = "ALLOWED"

println(map)

assert map."an identifier with a space and double quotes" == "ALLOWED"
assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""
map./slashy string/
map.$/dollar slashy string/$


def firstname ="Homer"
map."Simpson-${firstname}" = "Homer Simpson"

assert map.'Simpson-Homer' == "Homer Simpson"


/*
STRINGS
Text literals are represented in the form of chain of characters called strings. Groovy lets you instantiate java.lang.String objects,
as well as GStrings (groovy.lang.GString) which are also called "interpolated strings" in other programming languages.
 */

def a = '''a triple-single-quoted string'''
println(a)

def aMultilineString = '''line one
line two
line three'''
println(aMultilineString)

def strippedFirstNewline = '''\
line one
line two
line three
'''

assert !strippedFirstNewline.startsWith('\n')

/*
Any Groovy expression can be interpolated in all string literals, apart from single and triple-single-quoted strings.
Interpolation is the act of replacing a placeholder in the string with its value upon evaluation of the string.
The placeholder expressions are surrounded by ${}
 */

def name = 'Guillaume' // a plain string
def greeting = "Hello ${name}"

assert greeting.toString() == "Hello Guillaume"

def sum = "The sum of 2 and 3 equals ${2 + 3}"
assert sum.toString() == 'The sum of 2 and 3 equals 5'

def sum1 =  "The sum of 1 and 2 is equal to ${def x = 1; def b = 2; x + b}"
assert sum1.toString() == 'The sum of 1 and 2 is equal to 3'

//In addition to ${} placeholders, we can also use a lone $ sign prefixing a dotted expression:

def person = [name: 'Guillaume', age: 36]
assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

String thing = 'treasure'
assert 'The x-coordinate of the treasure is represented by treasure.x' ==
        "The x-coordinate of the $thing is represented by ${thing}.x"   // <= Not allowed: ambiguous!!  Curly braces added

/*
If you need to escape the $ or ${} placeholders in a GString so they appear as is without interpolation,
you just need to use a \ backslash character to escape the dollar sign:
 */

assert '$5' == "\$5"
assert '${name}' == "\${name}"

//The closure is a parameterless closure which doesn’t take arguments.
def sParameterLessClosure = "1 + 2 == ${-> 3}"
assert sParameterLessClosure == '1 + 2 == 3'

//	Here, the closure takes a single java.io.StringWriter argument,
//	to which you can append content with the << leftShift operator. In either case, both placeholders are embedded closures.

def sOneParamClosure = "1 + 2 == ${ w -> w << 3}" // you can append content with the << leftShift operator.
assert sOneParamClosure == '1 + 2 == 3'

//	We define a number variable containing 1 that we then interpolate within two GStrings,
//	as an expression in eagerGString and as a closure in lazyGString.
def number = 1
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"

assert eagerGString == "value == 1"
assert lazyGString ==  "value == 1"

number = 2
assert eagerGString == "value == 1" //With a plain interpolated expression, the value was actually bound at the time of creation of the GString.
assert lazyGString ==  "value == 2" // 	But with a closure expression, the closure is called upon each coercion of the GString into String, resulting in an updated string containing the new number value.





String takeString(String message) {
    assert message instanceof String //We also verify that the parameter is indeed a String and not a GString.
    return message
}

def message = "The message is ${'hellox'}" //Creating a GString variable
assert message instanceof GString // 	We double check it’s an instance of the GString

def result = takeString(message) // 	We then pass that GString to a method taking a String as parameter
assert result instanceof String
assert result == 'The message is hellox'

//Even for the same resulting string, GStrings and Strings don’t have the same hashCode.
assert "one: ${1}".hashCode() != "one: 1".hashCode()

def key = "a"
def m = ["${key}": "letter ${key}"] // 	The map is created with an initial pair whose key is a GString

assert m["a"] == null // When we try to fetch the value with a String key, we will not find it, as Strings and GString have different hashCode values


// Triple-double-quoted strings behave like double-quoted strings, with the addition that they are multiline, like the triple-single-quoted strings.

def namex = 'Groovy'
def template = """
    Dear Mr ${namex},

    You're the winner of the lottery!

    Yours sincerly,

    Dave
"""

assert template.toString().contains('Groovy')


// Slashy strings are particularly useful for defining regular expressions and patterns, as there is no need to escape backslashes.

def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'

//Only forward slashes need to be escaped with a backslash:

def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'

def multilineSlashy = /one
    two
    three/

assert multilineSlashy.contains('\n')

// Slashy strings can be thought of as just another way to define a GString but with different escaping rules. They hence support interpolation:

def color = 'blue'
def interpolatedSlashy = /a ${color} car/

assert interpolatedSlashy == 'a blue car'

//Dollar slashy strings are multiline GStrings delimited with an opening $/ and and a closing /$.

def namet = "Guillaume"
def date = "April, 1st"

def dollarSlashy = $/
    Hello $name,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $$$/ escaped opening dollar slashy
    $/$$ escaped closing dollar slashy
/$


assert [
        'Guillaume',
        'April, 1st',
        '$ dollar sign',
        '$ escaped dollar sign',
        '\\ backslash',
        '/ forward slash',
        '/ escaped forward slash',
        '$/ escaped opening dollar slashy',
        '/$ escaped closing dollar slashy'
].every { dollarSlashy.contains(it) }



//CHARACTERS
//Unlike Java, Groovy doesn’t have an explicit character literal.
// However, you can be explicit about making a Groovy string an actual character, by three different means:

char c1 = 'A' //by being explicit when declaring a variable holding the character by specifying the char type
assert c1 instanceof Character

def c2 = 'B' as char  // by using type coercion with the as operator
assert c2 instanceof Character

def c3 = (char)'C' // 	by using a cast to char operation
assert c3 instanceof Character




