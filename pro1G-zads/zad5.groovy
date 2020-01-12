
//1
static String reverseChars(String s) {
    String n = s.reverse()
    return n
}

println(reverseChars("Dog"))


// 2
static List<String> reverseWords(String s) {
    def list = []
    String[] str = s.split(" ")
    for(int i=0; i<str.length; i++){
        list.add(str[i])
    }
    def revlst = list.reverse();
    return revlst

}
println(reverseWords("ala ma kot"))

//3
static String joined(def list,String sep){
    String str = list.join(sep)
    return str
}

println(joined(['a','b','c'],'::'))

//4
def list = [
        [product:'Bread' , price:7 ],[product:'Bread' , price:5 ],[product:'Milk' , price:2 ],[product:'Milk' , price:5 ]
]
def sum = list.groupBy({it.product}).collectEntries {k, v -> [k, v.price.sum()]}

sum.each {println it}