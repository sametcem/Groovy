package lectures1_6

def text = ['A 100', 'A B']
def rlist = [ /[A-Z] \d\d\d/, /.../]

text.each { txt ->
    rlist.each { regex ->
        def msg = 'matches'
        if (!(txt ==~ regex)) msg = 'no ' + msg
        println "'$txt' $msg '$regex'"
    }
}