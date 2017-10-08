
/**
 * Write a description of class RailFenceFrame here.
 * 
 * @author Abid Ahmed
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RailFenceFrame extends GeneralFrame implements ActionListener
{
    // Text Field for key
    private JTextField keyField = new JTextField(3);
    
    public RailFenceFrame() {
        super();
        setTitle("Cryptography - Rail Fence Transposition");
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
        TranspositionCipher railFence;
        if (!(keyField.getText().equals(""))) {
            railFence = new RailFence(input.getText(), Integer.parseInt(keyField.getText()));
        } else {
            railFence = new RailFence(input.getText(), 0);
        }
        if (source == encrypt) {
            this.output.setText(railFence.encrypt());
        } else if (source == decrypt) {
            this.output.setText(railFence.decrypt());
        } else if (source == clear) {
            super.clear();
            keyField.setText("");
        } else {
            showHomeFrame();
        }
    }
    
    public static void main(String[] args) {
        RailFenceFrame.setLookAndFeel();
        RailFenceFrame railFence = new RailFenceFrame();
    }
}
