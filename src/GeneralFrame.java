
/**
 * Write a description of class GeneralFrame here.
 * 
 * @author Abid Ahmed 
 * @version 6-10-17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GeneralFrame extends JFrame
{

    // Row 1
    protected JPanel row1 = new JPanel();
    protected JLabel inputLabel = new JLabel("Input: ");
    protected JTextArea input = new JTextArea(6, 100);

    protected JScrollPane inputScroll = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    // Row 2 
    protected JPanel row2 = new JPanel();
    protected JLabel keyLabel = new JLabel("Key: ", JLabel.LEADING);
     // Row 3 
    protected JPanel row3 = new JPanel();
    protected JButton home = new JButton("Home");
    protected JButton encrypt = new JButton("Encrypt");
    protected JButton decrypt = new JButton("Decrypt");
    protected JButton clear = new JButton("Clear");
    // Row 4
    protected JPanel row4 = new JPanel();
    protected JLabel outputLabel = new JLabel("Output: ", JLabel.LEADING);
    protected JTextArea output = new JTextArea(6, 100);
    JScrollPane outputScroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    // Layouts
    protected FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 5, 30);
    protected FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 5, 45);
    protected  FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 5, -1);
    protected FlowLayout layout4 = new FlowLayout(FlowLayout.CENTER, 5, 15);
    
    public GeneralFrame() {
        super();
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setLookAndFeel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(4,2);
        setLayout(grid);
        setVisible(true);
        setResizable(false);
        // row 1
        row1.setLayout(layout1);
        row1.add(inputLabel);
        inputLabel.setLabelFor(input);
        row1.add(inputScroll);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        add(row1);
        // row 2
        row2.setLayout(layout2);
        row2.add(keyLabel);
        // row3 
        row3.setLayout(layout3);
        // row 4
        row4.setLayout(layout4);
        row4.add(outputLabel);
        outputLabel.setLabelFor(output);
        row4.add(outputScroll);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);
    }
    
    // Set the margins of the frame
    public Insets getInsets() {
        Insets border = new Insets(50,15,10,15);
        return border;
    }
    
    // Set the look and feel of the frame
    protected static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    // Clear method
    public void clear() {
        input.setText("");
        output.setText("");
    }
    
    // Show the home frame
    public void showHomeFrame() {
        HomeFrame homeFrame = new HomeFrame();
        dispose();
        homeFrame.setVisible(true);
    }
}
