
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author Abid Ahmed
 * @version 5-17-17
 */
public class CaesarCipher extends SubCipher
{
    private String myMessage;
    private int myKey;
    
    public CaesarCipher (String message, int key) {
        myMessage = message.toUpperCase();
        myMessage = cleanMessage(myMessage);
        myKey = key;
    }
    
    public String encrypt() {
        return format(getNewMessage(applyCipher(convertMessage(myMessage))));
    }
    
    public String decrypt() {
       return getNewMessage(revertCipher(convertMessage(myMessage)));
    }
    
    public int[] applyCipher(int[] arr) {
        int[] encryptedNums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                encryptedNums[i] = (arr[i] + myKey) % 26;
            } else {
                encryptedNums[i] = -1;
            }
        }
        return encryptedNums;
    }
    
    public int[] revertCipher(int[] arr) {
        int [] decryptedNums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                decryptedNums[i] = (arr[i] + (26 - myKey)) % 26;
            } else {
                decryptedNums[i] = -1;
            }
        }
        return decryptedNums;
    } 
}
