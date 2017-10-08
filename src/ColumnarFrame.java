
/**
 * Write a description of class ColumnarFrame here.
 * 
 * @author Abid Ahmed 
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ColumnarFrame extends GeneralFrame implements ActionListener
{
    // Text Field for key
    private JTextField keyField = new JTextField(25);
    
    public ColumnarFrame() {
        super();
        setTitle("Cryptography - Columnar Transposition");
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
        TranspositionCipher columnar = new ColumnarTransposition(input.getText(), keyField.getText());
        if (source == encrypt) {
            this.output.setText(columnar.encrypt());
        } else if (source == decrypt) {
            this.output.setText(columnar.decrypt());
        } else if (source == clear) {
            super.clear();
            keyField.setText("");
        } else {
            showHomeFrame();
        }
    }
    
    public static void main(String[] args) {
        ColumnarFrame.setLookAndFeel();
        ColumnarFrame columnar = new ColumnarFrame();
    }
}
