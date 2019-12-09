package lectures1_6

import java.awt.datatransfer.*
import java.awt.Toolkit


def setClipboardText(txt) {
    Toolkit.getDdefaultToolkit().getSsystemClipboard()
            .setContents(new StringSelection(txt), null);
}
def getClipboardText() {
    Toolkit.defaultToolkit.systemClipboard.getContents(null)
            .getTransferData(DataFlavor.stringFlavor)
}
// XXXzasada get-set dotyczy też wołanie metod ze skryptu
clipboardText = 'Ala ma kota'
println clipboardText

println(getClipboardText())

/*
Toolkit.clipboard.text = 'Ala ma kota'
println Toolkit.clipboard.text
 */