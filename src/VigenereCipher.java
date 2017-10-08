
/**
 * Write a description of class VigenereCipher here.
 * 
 * @author Abid Ahmed
 * @version 5-17-17
 */
public class VigenereCipher extends SubCipher
{
    private String myMessage;
    private int[] myKey;
    
    public VigenereCipher(String message, String key) {
        myMessage = message.toUpperCase();
        myMessage = cleanMessage(myMessage);
        myKey = convertMessage(key.toUpperCase());
    }
    
    public String encrypt() {
        return format(getNewMessage(applyCipher(convertMessage(myMessage))));
    }
    
    public String decrypt() {
        return getNewMessage(revertCipher(convertMessage(myMessage)));
    }
    
    public int[] applyCipher(int[] arr) {
        int[] encryptedNums = new int[arr.length];
        for (int i = 0; i < arr.length; i += myKey.length) {
            for (int j = 0; j < myKey.length; j++) {
                if (i + j < arr.length) {
                    if (arr[i+j] != -1) {
                        encryptedNums[i+j] = (arr[i+j] + myKey[j]) % 26;
                    } else {
                        encryptedNums[i+j] = -1;
                        if (i+j+1 < arr.length) {
                            encryptedNums[i+j+1] = (arr[i+j+1] + myKey[j]) %26;
                        }
                        i++;
                    }
                }
            }
        }
        return encryptedNums;
    }
   
    public int[] revertCipher(int[] arr) {
        int[] decryptedNums = new int[arr.length];
        for (int i = 0; i < arr.length; i += myKey.length) {
            for (int j = 0; j < myKey.length; j++) {
                if (i + j < arr.length) {
                    if (arr[i+j] != -1) {
                        decryptedNums[i+j] = (arr[i+j] + (26 - myKey[j])) % 26;
                    } else {
                        decryptedNums[i+j] = -1;
                        if (i+j+1 < arr.length) {
                            decryptedNums[i+j+1] = (arr[i+j+1] + (26 - myKey[j])) % 26;
                        }
                        i++;
                    }
                }
            }
        }
        return decryptedNums;
    }
}
