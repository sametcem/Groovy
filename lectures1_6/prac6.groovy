package lectures1_6

import javax.swing.*

def b = new JButton('AAA') // klasa ma metody get/setText
def l = new JLabel('BBB') // klasa ma metody get/setText

class A {
    private String text = 'initial'
    String getText() { return text }
    void setText(String s) { text = s}
}

def a = new A()
for (c in [b, l, a]) println c.text
for (c in [b, l, a]) c.text = "change $c.text"
for (c in [b, l, a]) println c.text