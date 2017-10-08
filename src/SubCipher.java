
/**
 * Abstract class Cipher - write a description of the class here
 * 
 * @author Abid Ahmed
 * @version 5-17-17
 */
import java.util.ArrayList;
public abstract class SubCipher extends Cipher
{
    // This method is an abstract helper method which will apply a certain cipher to the message
    public abstract int[] applyCipher(int[] arr);
    
    // This method is an abstract helper method which will revert a certain cipher to the message
    public abstract int[] revertCipher(int[] arr);
    
    // This is a helper method that will convert the message into an array of numbers
    public int[] convertMessage(String message) {
        int[] converted = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            converted[i] = alphabet.indexOf(message.substring(i,i+1));
        }
        return converted;
    }
    
    // This will convert numbers into letter
    public String getNewMessage(int[] finalNums) {
        String finalMessage = "";
        for (int i = 0; i < finalNums.length; i++) {
            if (finalNums[i] == -1) {
                finalMessage += "/";
            } else {
                finalMessage += alphabet.substring(finalNums[i],finalNums[i]+1);
            }
        }
        return finalMessage;
    }
}
