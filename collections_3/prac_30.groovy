package collections_3

//Currency
//API doesnt work!
import groovy.json.JsonSlurper
def ask = { msg-> javax.swing.JOptionPane.showInputDialog(msg) }
def base = ask 'Enter base currency symbol'
def currs = ask('Currencies to calc').tokenize().join(',')
def xmap = new JsonSlurper().parse(
        new URL("https://api.exchangeratesapi.io/latest"))
def amt = ask('Enter money ammount').toInteger()
xmap.rates.each { k, v ->
    println "$amt $k = ${String.format('%.2f', amt/v)} $xmap.base"
}

