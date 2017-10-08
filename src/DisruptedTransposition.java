
/**
 * Write a description of class DisruptedTransposition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisruptedTransposition extends TranspositionCipher
{ 
    private String myMessage;
    private String myKey;
    
    public DisruptedTransposition (String message, String key) {
        myMessage = cleanMessage(message);
        myKey = key.toUpperCase();
    }
    
    public String encrypt() {
        int[] orderedKey = orderKey(myKey);
        String[][] transBoard = new String[orderedKey.length][orderedKey.length];
        for (int i = 0; i < transBoard.length; i++) {
            for (int j = 0; j < transBoard[0].length; j++) {
                transBoard[i][j] = "";
            }
        }
        int place = 0;
        int count = 1;
        // Fill in letters while following the disrupted pattern
        for (int k = 0; k < orderedKey.length; k++) {
            if (orderedKey[k] == count && count-1 < transBoard.length) {
                for (int j = 0; j <= k; j++) {
                    if (place < myMessage.length()) {
                        transBoard[count-1][j] = myMessage.substring(place, place+1);
                        place++;
                    }
               }
               count++;
               k = -1;
            }
        }
        // Fill in the blanks for any remaining letters
        for (int i = 0; i < transBoard.length; i++) {
            for (int j = 0; j < transBoard[0].length; j++) {
                if (transBoard[i][j].equals("") && place < myMessage.length()) {
                    transBoard[i][j] = myMessage.substring(place, place+1);
                    place++;
                }
            }
        }
        return format(getCipherText(transBoard, orderedKey));
    }
    // Decrypting a disruption cipher takes trial and error
    public String decrypt() {
        return null;
    }
}
