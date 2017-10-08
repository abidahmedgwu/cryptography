
/**
 * Write a description of class ColumnarTransposition here.
 * 
 * @author Abid Ahmed
 * @version 5-30-17
 */
public class ColumnarTransposition extends TranspositionCipher
{
    private String myMessage;
    public String myKey;
    
    public ColumnarTransposition (String message, String key) {
        myMessage = cleanMessage(message);
        myKey = key.toUpperCase();
    }
    
    public String encrypt() {
        return format(getCipherText(fillArray(myMessage, myKey), orderKey(myKey)));
    }
    
    public String decrypt(){
        return getDecryptedText(fillDecryptArr(myMessage, myKey));
    }
}
