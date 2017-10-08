
/**
 * Abstract class TranspositionCipher - write a description of the class here
 * 
 * @author Abid Ahmed
 * @version 5-27-17
 */
public abstract class TranspositionCipher extends Cipher
{   
   // This method will assign numbers to the key in ABC order
   public int[] orderKey(String key) {
        key = key.toUpperCase();
        // Make an array containing the letters of the key
        String[] keyArr = new String[key.length()];
        for (int i = 0; i < keyArr.length; i++) {
            keyArr[i] = key.substring(i,i+1);
        }
        // Order the array in alphabetical order
        for (int i = 1; i < keyArr.length; i++) {
            for (int j = 0; j < keyArr.length; j++) {
                if (keyArr[i].compareTo(keyArr[j]) < 0) {
                    String temp = keyArr[i];
                    keyArr[i] = keyArr[j];
                    keyArr[j] = temp;
                }
            }
        }
        // Create a string containing the letters of the keyArr
        String keyInOrder = "";
        for (int i = 0; i < keyArr.length; i++) {
            keyInOrder += keyArr[i];
        }
        // Assign numbers to the letters according to ABC order.
        int[] ordered = new int[key.length()];
        for (int i = 0; i < keyInOrder.length(); i++) {
            ordered[i] = keyInOrder.indexOf(key.substring(i,i+1))+1;
        }
        // Make sure there are no duplicate numbers
        for (int i = 0; i < ordered.length; i++) {
            for (int j = i+1; j < ordered.length; j++) {
                if (ordered[i] == ordered[j]) {
                    ordered[j]++;
                }
            }
        }
        return ordered;
   }
   // This method will fill the 2D array for the columnar and double transposition
   public String[][] fillArray(String message, String key) {
        String[][] filledArr = getTranspositionBoard(message, key);
        int place = 0;
        for (int i = 0; i < filledArr.length; i++) {
            for (int j = 0; j < filledArr[0].length; j++) {
                if (place < message.length()) {
                    filledArr[i][j] = message.substring(place, place+1);
                    place++;
                }
            }
        }
        return filledArr;
   }
   // This method will read the cipher text in the transposed array
   public String getCipherText(String[][] filledArr, int[] key) {
        String cipherText = "";
        int count = 1;
        for (int k = 0; k < key.length; k++) {
            if (key[k] == count) {
                for (int i = 0; i < filledArr.length; i++) {
                    cipherText += filledArr[i][k];
                }
                count++;
                k = -1;
            }
        }
        return cipherText;
   }
   // This method will fill in a 2D transposition array for decrypting a Columnar or Double Transposition
   public String[][] fillDecryptArr(String message, String key) {
       String[][] filledArr = getTranspositionBoard(message, key);
       int[] orderedKey = orderKey(key);
       int place = 0;
       int count = 1;
       for (int k = 0; k < orderedKey.length; k++) {
           if (orderedKey[k] == count) {
               for (int i = 0; i < filledArr.length; i++) {
                   if (i*orderedKey.length + k >= message.length()) {
                       filledArr[i][k] = "";
                   } else if (place < message.length() 
                            && !(i*orderedKey.length + k >= message.length())) {
                       filledArr[i][k] = message.substring(place, place+1);
                       place++;
                   }
               }
               count++;
               k = -1;
           }
       }
       return filledArr;
   }
   // This helper method will create a 2D array with the right dimensions for a transposition cipher.
   public String[][] getTranspositionBoard(String message, String key) {
        message = message.toUpperCase();
        key = key.toUpperCase();
        int msgLen = message.length();
        int keyLen = key.length();
        String[][] filledArr;
        if (msgLen % keyLen == 0) {
            filledArr = new String[msgLen/keyLen][keyLen];
        } else {
            filledArr = new String[(msgLen/keyLen)+1][keyLen];
        }
        for (int i = 0; i < filledArr.length; i++) {
            for (int j = 0; j < filledArr[0].length; j++) {
                filledArr[i][j] = "";
            }
        }
        return filledArr;
   }
   // This method returns the decrypted string for a transposition cipher
   public String getDecryptedText(String[][] filledArr) {
       String message = "";
       for (int i = 0; i < filledArr.length; i++) {
           for (int j = 0; j < filledArr[0].length; j++) {
               message += filledArr[i][j];
           }
       }
       return message;
   }
}
