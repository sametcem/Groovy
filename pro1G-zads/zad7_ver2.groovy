
//1
def empsMap = [:]
def projektyDuzeFile = new File('C:\\Users\\samet\\IdeaProjects\\zads2\\src\\Zad07resources\\projekyDuze')
def projektyFile = new File('C:\\Users\\samet\\IdeaProjects\\zads2\\src\\Zad07resources\\Projekty').eachLine { line ->
    def tokens = line.tokenize('\t')
    def project = tokens[0]
    def emps = tokens[1..tokens.size() - 1]
    emps.each { emp ->
        if (empsMap.containsKey(emp))
            empsMap.get(emp).add(project)
        else {
            def nList = [project]
            empsMap.put(emp, nList)
        }
    }
    if (emps.size() > 3) projektyDuzeFile << "$project: $emps \n"
}

def programisciFile = new File('C:\\Users\\samet\\IdeaProjects\\zads2\\src\\Zad07resources\\programisci')
empsMap.each { key, value -> programisciFile << "Dev: $key \nProjekty: $value \n\n" }



//2
import groovy.json.JsonSlurper

def urlString = 'https://api.exchangeratesapi.io/latest?base=EUR'
def apiResult = (new JsonSlurper()).parse(
        new InputStreamReader(
                (new URL(urlString)).newInputStream()
        )
)
def plnValue = apiResult.rates.PLN

def MenuEURFile = new File('C:\\Users\\samet\\IdeaProjects\\zads2\\src\\Zad07resources\\MenuEUR')
new File('C:\\Users\\samet\\IdeaProjects\\zads2\\src\\Zad07resources\\MenuPl').eachLine { line ->
    def tokens = line.tokenize('\t')
    def food = tokens.first()
    def price = tokens.last().tokenize(' ').first()
    def priceEUR = String.format("%.2f", price.toBigDecimal()/plnValue.toBigDecimal())

    MenuEURFile << "$food: $priceEUR EUR\n"
}

//3
def resourcesDir = new File('C:\\Users\\samet\\IdeaProjects\\zads2\\src\\TestDir')
resourcesDir.eachDirRecurse {
    it.eachFileMatch( ~/\w+\.html/) { println "$it" }
}
