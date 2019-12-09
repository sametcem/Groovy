package lectures1_6

def text = '20 monday 100 tuesday 200 friday 500 sat'
def list = text.split(/\D/)
println list

list = text.split(/\D+/)
println list


texta = ' 20 monday 100 tuesday 200 friday 500 sat'
lista = text.split(/\D+/)
println lista