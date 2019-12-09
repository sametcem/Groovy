package lectures1_6

def text = 'Groovy is cool with regex'
def regex = 'o'
def matcher = text =~ regex

show(text, matcher)
text = 'xxxo'
matcher.reset(text)
show(text, matcher)


def show(txt, m) {
    def regex = m.pattern()
    while (m.find()) {
        println "In '$txt' found '$regex' start: ${m.start()} end: ${m.end()}"
    }
}