package lectures1_6

//REGEX
// text =~ regex

def text = 'Groovy is cool with regex'

if(text =~'x') println 'x found'
else println 'x not found'


if(text =~'z') println 'z found'
else println 'z not found'


//text ==~ regex
//true if all text matches the regex pattern.

def text2= 'Groovy'
if (text2 ==~'Groovy') println 'Groovy'
else println 'No match'
if (text2 ==~'Java') println 'Java'
else println 'No match'

def matcher = 'ala' =~ 'a'
println matcher