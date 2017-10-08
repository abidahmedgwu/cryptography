
/**
 * Write a description of class HomeFrame here.
 * 
 * @author Abid Ahmed
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HomeFrame extends JFrame implements ActionListener
{
    private JPanel row2 = new JPanel();
    private JButton caesar = new JButton("Caesar");
    private JButton vigenere = new JButton("Vigenere");
    private JButton columnarTransposition = new JButton("Columnar");
    private JButton doubleTransposition = new JButton("Double");
    private JButton disruptedTransposition = new JButton("Disrupted");
    private JButton railFence = new JButton("Rail Fence");
    
    public HomeFrame() {
        super("Cryptography - Home");
        setSize(650, 100);
        setLocationRelativeTo(null);
        setLookAndFeel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER);
        setResizable(false);
        row2.setLayout(layout1);
        caesar.addActionListener(this);
        vigenere.addActionListener(this);
        columnarTransposition.addActionListener(this);
        doubleTransposition.addActionListener(this);
        disruptedTransposition.addActionListener(this);
        railFence.addActionListener(this);
        row2.add(caesar);
        row2.add(vigenere);
        row2.add(columnarTransposition);
        row2.add(doubleTransposition);
        row2.add(disruptedTransposition);
        row2.add(railFence);
        add(row2);
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    // Set margins
    public Insets getInsets() {
        Insets border = new Insets(50,15,10,15);
        return border;
    }
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == caesar) {
            CaesarFrame caesarFrame = new CaesarFrame();
            dispose();
            caesarFrame.setVisible(true);
        } else if (source == vigenere) {
            VigenereFrame vigenereFrame = new VigenereFrame();
            dispose();
            vigenereFrame.setVisible(true);
        } else if (source == columnarTransposition) {
            ColumnarFrame columnar = new ColumnarFrame();
            dispose();
            columnar.setVisible(true);
        } else if (source == doubleTransposition) {
            DoubleFrame doubleTrans = new DoubleFrame();
            dispose();
            doubleTrans.setVisible(true);
        } else if (source == disruptedTransposition) {
            DisruptedFrame disrupted = new DisruptedFrame();
            dispose();
            disrupted.setVisible(true);
        } else if (source == railFence) {
            RailFenceFrame railFence = new RailFenceFrame();
            dispose();
            railFence.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        HomeFrame.setLookAndFeel();
        HomeFrame home = new HomeFrame();
    }
}
