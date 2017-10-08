/**
 * Created by aahme on 8/3/2017.
 */
public class Password {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_ALPHABET = ALPHABET.toLowerCase();
    public static final String SYMBOLS = "0123456789!@#$%^&*()[]?.,";
    private String use;
    private String password;
    private String key1;
    private String key2;
    private String key3;

    public Password(String use, String password, String key1, String key2, String key3) {
        this.use = use;
        this.password = password;
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }

    // Accessor Methods
    public String getUse() { return use; }
    public String getPassword() { return password; }
    public String getEncryptedPassword() { return encryptPassword(); }
    public String getkey1() { return key1; }
    public String getkey2() { return key2; }
    public String getKey3() { return key3; }

    // Create encryptPassword() method
    public String encryptPassword() {
        SubCipher vigenereEncrypt = new VigenereCipher(password, key1);
        TranspositionCipher doubleEncrypt = new DoubleTransposition(vigenereEncrypt.encrypt(), key2, key3);
        String encryptedPassword = doubleEncrypt.encrypt();
        String finalEncryptedPassword = "";
        for (int i = 0; i < encryptedPassword.length(); i++) {
            String currentChar = encryptedPassword.substring(i,i+1);
            if (ALPHABET.indexOf(currentChar) >= 0) {
                finalEncryptedPassword += currentChar;
            } else {
                // Encrypting takes out special characters. FIX
                System.out.println(currentChar);
                finalEncryptedPassword += LOWER_ALPHABET.substring(SYMBOLS.indexOf(currentChar), SYMBOLS.indexOf(currentChar)+1);
            }
        }
        return finalEncryptedPassword;
    }
}