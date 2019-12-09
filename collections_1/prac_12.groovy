package collections_1

//              collectEntries

//public Map collectEntries(Closure transform)
//Iterates through this Collection transforming each item using the
// transform closure and returning a map of the resulting transformed entries.

def letters = "abc"
// collect letters with index using list style
def n = letters.size()-1
def map = (0..n).collectEntries { ind -> [ind, letters[ind]]}
println map

// collect letters with index using map style
map = (0..n).collectEntries { ind -> [(ind) : letters[ind]] }
println map

def l1 = [ 'a', 'b', 'c']
def l2 = [1,2,3]
map = (0..<l1.size()).collectEntries { i -> [ l1[i] , l2[i]] }
println map