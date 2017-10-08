
/**
 * Write a description of class VigenereFrame here.
 * 
 * @author Abid Ahmed
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VigenereFrame extends GeneralFrame implements ActionListener 
{
    // Text Field for key
    private JTextField keyField = new JTextField(25);
    
    public VigenereFrame() {
        super();
        setTitle("Cryptography - Vigenere Substitution");
        // row 2
        keyLabel.setLabelFor(keyField);
        row2.add(keyField);
        add(row2);
        // row 3
        encrypt.addActionListener(this);
        row3.add(encrypt);
        decrypt.addActionListener(this);
        row3.add(decrypt); 
        clear.addActionListener(this);
        row3.add(clear);
        home.addActionListener(this);
        row3.add(home);
        add(row3);
        // row 4
        add(row4);
    }
    
    // Respond to button press
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        SubCipher vigenere = new VigenereCipher(input.getText(), keyField.getText());
        if (source == encrypt) {
            this.output.setText(vigenere.encrypt());
        } else if (source == decrypt) {
            this.output.setText(vigenere.decrypt());
        } else if (source == clear) {
            super.clear();
            keyField.setText("");
        } else {
            showHomeFrame();
        }
    }
    
    public static void main(String[] args) {
        VigenereFrame.setLookAndFeel();
        VigenereFrame vigenere = new VigenereFrame();
    }
}
