
/**
 * Write a description of class DoubleTransposition here.
 * 
 * @author Abid Ahmed
 * @version 5-30-17
 */
public class DoubleTransposition extends TranspositionCipher
{
    private String myMessage;
    private String myKey1;
    private String myKey2;
    
    public DoubleTransposition(String message, String key1, String key2) {
        myMessage = cleanMessage(message);
        myKey1 = key1.toUpperCase();
        myKey2 = key2.toUpperCase();
    }
    
    public String encrypt() {
        TranspositionCipher first = new ColumnarTransposition(myMessage, myKey1);
        TranspositionCipher second = new ColumnarTransposition(first.encrypt(), myKey2);
        return second.encrypt();
    }
    
    public String decrypt() {
        TranspositionCipher first = new ColumnarTransposition(myMessage, myKey2);
        TranspositionCipher second = new ColumnarTransposition(first.decrypt(), myKey1);
        return second.decrypt();
    }
}
