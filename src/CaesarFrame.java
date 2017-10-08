
/**
 * Write a description of class CaesarFrame here.
 * 
 * @author Abid Ahmed
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CaesarFrame extends GeneralFrame implements ItemListener, ActionListener 
{
    // Dropdown menu for key
    private JComboBox<Integer> keyChoice = new JComboBox<Integer>();
    private int key;
    
    public CaesarFrame() {
        super();
        setTitle("Cryptography - Caesar Substitution");
        // row 2
        keyLabel.setLabelFor(keyChoice);
        row2.add(keyChoice);
        for (int i = 0; i <= 25; i++) {
            keyChoice.addItem(i);
        }
        keyChoice.setEditable(false);
        keyChoice.addItemListener(this);
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
    
    // Respond to key choice
    public void itemStateChanged(ItemEvent item) {
        String selection = item.getItem().toString();
        key = Integer.parseInt(selection);
    }
    
    // Respond to button press
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        SubCipher caesar = new CaesarCipher(input.getText(), key);
        if (source == encrypt) {
            this.output.setText(caesar.encrypt());
        } else if (source == decrypt) {
            this.output.setText(caesar.decrypt());
        } else if (source == clear) {
            super.clear();
            keyChoice.setSelectedIndex(0);
        } else {
            showHomeFrame();
        }
    }
    
    public static void main(String[] args) {
        CaesarFrame.setLookAndFeel();
        CaesarFrame caesar = new CaesarFrame();
    }
}
