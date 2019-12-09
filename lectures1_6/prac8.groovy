package lectures1_6

import java.awt.datatransfer.*
import java.awt.Toolkit

// Dodanie statycznej metody getClipboard() do Toolkit
// metoda zwraca referencję typu Clipboard
Toolkit.metaClass.static.getClipboard = {
    Toolkit.getDefaultToolkit().getSystemClipboard()
}
// dodanie metod getText i setText do klasy Clipboard
Clipboard.metaClass.getText = {
    getContents(null).getTransferData(DataFlavor.stringFlavor)
}
Clipboard.metaClass.setText = { txt->
    getContents(null).setContents(new StringSelection(txt), null)
}
// i teraz bez problemu działa:
Toolkit.clipboard.text = 'Ala ma kota'
println Toolkit.clipboard.text