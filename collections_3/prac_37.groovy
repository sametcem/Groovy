package collections_3

// Map collections, dot and star-dot operator

def mapList = [ [a: 1, b: 2], [a: 10, b: 11],
                [a: 20, b: 21 ], null ]
println mapList.a
println mapList*.a
println mapList.b
println mapList*.b