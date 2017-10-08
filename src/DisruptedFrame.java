
/**
 * Write a description of class DisruptedFrame here.
 * 
 * @author Abid Ahmed
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DisruptedFrame extends GeneralFrame implements ActionListener
{
    // Text Field for key
    private JTextField keyField = new JTextField(25);
    
    public DisruptedFrame() {
        super();
        setTitle("Cryptography - Disrupted Transposition");
        // row 2
        keyLabel.setLabelFor(keyField);
        row2.add(keyField);
        add(row2);
        // row 3
        encrypt.addActionListener(this);
        row3.add(encrypt); 
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
        TranspositionCipher disrupted = new DisruptedTransposition(input.getText(), keyField.getText());
        if (source == encrypt) {
            this.output.setText(disrupted.encrypt());
        } else if (source == clear) {
            super.clear();
            keyField.setText("");
        } else {
            showHomeFrame();
        }
    }
    
    public static void main(String[] args) {
        DisruptedFrame.setLookAndFeel();
        DisruptedFrame disrupted = new DisruptedFrame();
    }
}
