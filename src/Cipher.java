
/**
 * Abstract class Cipher - write a description of the class here
 * 
 * @author Abid Ahmed
 * @version 5-27-17
 */
public abstract class Cipher
{
    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // This method will encrypt the message based on the cipher
    public abstract String encrypt();
    
    // This method will encrypt the message based on the cipher
    public abstract String decrypt();
    
    // Formats the encrypted message into groups of five
    public String format(String message) {
        String formatted = "";
        for (int i = 0; i < message.length(); i += 5) {
            if (i+5 <= message.length()) {
                formatted += message.substring(i, i+5);
                formatted += " ";
            } else {
                formatted += message.substring(i);
            }
        }
        return formatted;
    }
    
    // Removes punctuation and spaces from the message.
    public String cleanMessage(String message) {
        message = message.toUpperCase();
        String cleaned = ""; 
        for (int i = 0; i < message.length(); i++) {
            if (alphabet.indexOf(message.substring(i, i+1)) != -1) {
                cleaned += message.substring(i, i+1);
            }
        }
        return cleaned;
    }
}
