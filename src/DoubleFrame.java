
/**
 * Write a description of class DoubleFrame here.
 * 
 * @author Abid Ahmed 
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DoubleFrame extends GeneralFrame implements ActionListener
{
    // Text Fields for keys
    private JTextField keyField1 = new JTextField(25);
    private JTextField keyField2 = new JTextField(25);
    private JLabel keyLabel1 = new JLabel("Key 1: ");
    private JLabel keyLabel2 = new JLabel("  Key 2: ");
   
    public DoubleFrame() {
        super();
        setTitle("Cryptography - Double Transposition");
        // row 2
        row2.remove(keyLabel);
        row2.add(keyLabel1);
        keyLabel1.setLabelFor(keyField1);
        row2.add(keyField1);
        row2.add(keyLabel2);
        keyLabel2.setLabelFor(keyField2);
        row2.add(keyField2);
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
        TranspositionCipher doubleTrans = new DoubleTransposition(input.getText(), keyField1.getText(), 
                                                keyField2.getText());
        if (source == encrypt) {
            this.output.setText(doubleTrans.encrypt());
        } else if (source == decrypt) {
            this.output.setText(doubleTrans.decrypt());
        } else if (source == clear) {
            super.clear();
            keyField1.setText("");
            keyField2.setText("");
        } else {
            showHomeFrame();
        }
    }
    
    public static void main(String[] args) {
        DoubleFrame.setLookAndFeel();
        DoubleFrame doubleFrame = new DoubleFrame();
    }
}
