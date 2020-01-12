

//2
println 'Hello, world'

//4

BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
print "Input:"
def userInput = br.readLine()
def numberVerbals = ["jeden","dwa","trzy","cztery","pięć","sześć","siedem","osiem","dziewięć"]

for(int i=0; i<userInput.length();i++){
switch (userInput[i].toString()){
    case "1":
        print(numberVerbals[0] + " ")
        break;
    case "2":
        print(numberVerbals[1] + " ")
        break;
    case "3":
        print(numberVerbals[2] + " ")
        break;
    case "4":
        print(numberVerbals[3] + " ")
        break;
    case "5":
        print(numberVerbals[4] + " ")
        break;
    case "6":
        print(numberVerbals[5] + " ")
        break;
    case "7":
        print(numberVerbals[6] + " ")
        break;
    case "8":
        print(numberVerbals[7] + " ")
        break;
    case "9":
        print(numberVerbals[8] + " ")
        break;
    default:
        print 'Undefined'
        break;
    }
}
println()

// 5
def list = [
        [product:'Bread' , price:10 ],[product:'Bread' , price:30 ],[product:'Milk' , price:20 ],[product:'Milk' , price:20 ]
]
def sum = list.groupBy({it.product}).collectEntries {k, v -> [k, v.price.sum()]}

sum.each {println it}


