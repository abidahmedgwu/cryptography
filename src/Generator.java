/**
 * Created by Abid on 8/3/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Generator {
    // private HashMap<String, ArrayList<String>>;
    public static final String SYMBOLS = "0123456789!@#$%^&*()[]?+-/";
    public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String CHARACTER_POOL = ALPHABET + SYMBOLS;

    // Generates a random password. String use refers to what the password will be used for.
    public Password generatePassword(int length, String use) {
        String password = "";
        for (int i = 0; i < length; i++) {
            int index = (int)(Math.random()*52);
            password += CHARACTER_POOL.substring(index,index+1);
        }
        // Vignere Cipher key
        String key1 = "";
        int key1_length = (int)(Math.random()*password.length());
        for (int i = 0; i < key1_length; i++) {
            int index = (int) (Math.random()*26);
            key1 += ALPHABET.substring(index,index+1);
        }
        // Double Transposition Key1
        String key2 = "";
        int key2_length = (int)((Math.random()*password.length())+1);
        for (int i = 0; i < key2_length; i++) {
            int index = (int)(Math.random()*26);
            key2 += ALPHABET.substring(index,index+1);
        }
        // Double Transposition Key2
        String key3 = "";
        int key3_length = (int)((Math.random()*password.length())+1);
        for (int i = 0; i < key3_length; i++) {
            int index = (int)(Math.random()*26);
            key3 += ALPHABET.substring(index,index+1);
        }

        return (new Password(use, password, key1, key2, key3));
    }
}
