
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrapTester
{
    public static void main(String[] args) {
        int[] key = orderKey("ALADIN");
        for (int i = 0; i < key.length; i++) {
            System.out.print(key[i] + " ");
        }
        System.out.println();
        String[][] table = (fillArray("WECONFIRMTHEDELIVERYOFTHEDOCUMENTSX", "ALADIN"));
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(getDecryptedMessage(fillArray("WECONFIRMTHEDELIVERYOFTHEDOCUMENTSX", "ALADIN"), orderKey("ALADIN")));
    }
    // This method will assign numbers to the key in ABC order
    public static int[] orderKey(String key) {
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
    public static String[][] fillArray(String message, String key) {
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
        int place = 0;
        for (int i = 0; i < filledArr.length; i++) {
            for (int j = 0; j < filledArr[0].length; j++) {
                if (place < msgLen) {
                    filledArr[i][j] = message.substring(place, place+1);
                    place++;
                } else {
                    filledArr[i][j] = "";
                }
            }
        }
        return filledArr;
    }
    // This method will read the cipher text in the transposed array
    public static String getDecryptedMessage(String[][] filledArr, int[] key) {
        String cipherText = "";
        int count = 1;
        for (int k = 0; k < key.length; k++) {
            if (key[k] == count) {
                for (int i = 0; i < filledArr.length; i++) {
                    cipherText += filledArr[i][k];
                }
                count++;
                k = 0;
            }
        }
        return cipherText;
    }
}
