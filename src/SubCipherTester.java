
/**
 * Write a description of class SubCipherTester here.
 * 
 * @author Abid Ahmed
 * @version 5-21-17
 */
public class SubCipherTester
{
   public static void main(String[] args) {
       System.out.println("Test 1");
       SubCipher test1 = new CaesarCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1);
       int[] caesarConverted = test1.convertMessage("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
       for (int i = 0; i < caesarConverted.length; i++) {
           System.out.print(caesarConverted[i] + " ");
       }
       System.out.println();
       int[] caesarEncrypted = test1.applyCipher(caesarConverted);
       for (int i = 0; i < caesarEncrypted.length; i++) {
           System.out.print(caesarEncrypted[i] + " ");
       }
       System.out.println();
       String newMessage = test1.getNewMessage(caesarEncrypted);
       System.out.println("New Message: " + newMessage);
       String cleanMessage = test1.cleanMessage(newMessage);
       System.out.println("Cleaned Message: " + cleanMessage);
       System.out.println("Encrypted Message: " + test1.encrypt());
       System.out.println("Decrypted Message: " + test1.decrypt());
       System.out.println();
       System.out.println();
       
       System.out.println("Test 2");
       SubCipher test2 = new CaesarCipher("HELLOWORLD", 20);
       caesarConverted = test2.convertMessage("HELLOWORLD");
       for (int i = 0; i < caesarConverted.length; i++) {
           System.out.print(caesarConverted[i] + " ");
       }
       System.out.println();
       caesarEncrypted = test2.applyCipher(caesarConverted);
       for (int i = 0; i < caesarEncrypted.length; i++) {
           System.out.print(caesarEncrypted[i] + " ");
       }
       System.out.println();
       newMessage = test2.getNewMessage(caesarEncrypted);
       System.out.println("New Message: " + newMessage);
       cleanMessage = test2.cleanMessage(newMessage);
       System.out.println("Cleaned Message: " + cleanMessage);
       System.out.println("Encrypted Message: " + test2.encrypt());
       System.out.println("Decrypted Message: " + test2.decrypt());
       System.out.println();
       System.out.println();
       
       System.out.println("Test 3");
       SubCipher test3 = new CaesarCipher("Hello World.", 5);
       caesarConverted = test3.convertMessage("Hello World.".toUpperCase());
       for (int i = 0; i < caesarConverted.length; i++) {
           System.out.print(caesarConverted[i] + " ");
       }
       System.out.println();
       caesarEncrypted = test3.applyCipher(caesarConverted);
       for (int i = 0; i < caesarEncrypted.length; i++) {
           System.out.print(caesarEncrypted[i] + " ");
       }
       System.out.println();
       newMessage = test3.getNewMessage(caesarEncrypted);
       System.out.println("New Message: " + newMessage);
       cleanMessage = test3.cleanMessage(newMessage);
       System.out.println("Cleaned Message: " + cleanMessage);
       System.out.println("Encrypted Message: " + test3.encrypt());
       System.out.println("Decrypted Message: " + test3.decrypt());
       System.out.println();
       System.out.println();
       
       System.out.println("Vigenere Cipher Test 1");
       SubCipher test4 = new VigenereCipher("HelloWorld", "Lemon");
       int[] vigenereConverted = test4.convertMessage("HelloWorld".toUpperCase());
       System.out.println("Converted Message");
       for (int i = 0; i < vigenereConverted.length; i++) {
           System.out.print(vigenereConverted[i] + " ");
       }
       System.out.println();
       System.out.println("Converted Key");
       int[] vigenereKey = test4.convertMessage("Lemon".toUpperCase());
       for (int i = 0; i < vigenereKey.length; i++) {
           System.out.print(vigenereKey[i] + " ");
       }
       System.out.println();
       System.out.println("Encrypted Numbers");
       int[] vigenereEncrypted = test4.applyCipher(vigenereConverted);
       for (int i = 0; i < vigenereEncrypted.length; i++) {
           System.out.print(vigenereEncrypted[i] + " ");
       }
       System.out.println();
       newMessage = test4.getNewMessage(vigenereEncrypted);
       System.out.println("New Message: " + newMessage);
       cleanMessage = test4.cleanMessage(newMessage);
       System.out.println("Cleaned Message: " + cleanMessage);
       System.out.println("Encrypted Message: " + test4.encrypt());
       System.out.println("Decrypted Message: " + test4.decrypt());
       System.out.println();
       System.out.println();
       
       System.out.println("Vigenere Cipher Test 2");
       SubCipher test5 = new VigenereCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Testing");
       vigenereConverted = test5.convertMessage("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toUpperCase());
       System.out.println("Converted Message");
       for (int i = 0; i < vigenereConverted.length; i++) {
           System.out.print(vigenereConverted[i] + " ");
       }
       System.out.println();
       System.out.println("Converted Key");
       vigenereKey = test5.convertMessage("Testing".toUpperCase());
       for (int i = 0; i < vigenereKey.length; i++) {
           System.out.print(vigenereKey[i] + " ");
       }
       System.out.println();
       System.out.println("Encrypted Numbers");
       vigenereEncrypted = test5.applyCipher(vigenereConverted);
       for (int i = 0; i < vigenereEncrypted.length; i++) {
           System.out.print(vigenereEncrypted[i] + " ");
       }
       System.out.println();
       newMessage = test5.getNewMessage(vigenereEncrypted);
       System.out.println("New Message: " + newMessage);
       cleanMessage = test5.cleanMessage(newMessage);
       System.out.println("Cleaned Message: " + cleanMessage);
       System.out.println("Encrypted Message: " + test5.encrypt());
       System.out.println("Decrypted Message: " + test5.decrypt());
       System.out.println();
       System.out.println();
       
       System.out.println("Vigenere Cipher Test 3");
       SubCipher test6 = new VigenereCipher("Hello World.", "Lemon");
       vigenereConverted = test6.convertMessage("Hello World.".toUpperCase());
       System.out.println("Converted Message");
       for (int i = 0; i < vigenereConverted.length; i++) {
           System.out.print(vigenereConverted[i] + " ");
       }
       System.out.println();
       System.out.println("Converted Key");
       vigenereKey = test6.convertMessage("Lemon".toUpperCase());
       for (int i = 0; i < vigenereKey.length; i++) {
           System.out.print(vigenereKey[i] + " ");
       }
       System.out.println();
       System.out.println("Encrypted Numbers");
       vigenereEncrypted = test6.applyCipher(vigenereConverted);
       for (int i = 0; i < vigenereEncrypted.length; i++) {
           System.out.print(vigenereEncrypted[i] + " ");
       }
       System.out.println();
       newMessage = test6.getNewMessage(vigenereEncrypted);
       System.out.println("New Message: " + newMessage);
       cleanMessage = test6.cleanMessage(newMessage);
       System.out.println("Cleaned Message: " + cleanMessage);
       System.out.println("Encrypted Message: " + test6.encrypt());
       System.out.println("Decrypted Message: " + test6.decrypt());
       System.out.println();
       System.out.println();
       
       
       
   }
}
