package lectures1_6

def txt = 'London 1957 Warsaw 2009'
def regex = /(\w+)\s+(\d+)/
def matcher = txt =~ regex

while (matcher.find()) {
    for (int i = 0; i <= matcher.groupCount(); i++)
        println i + ' ' + matcher.group(i)
}