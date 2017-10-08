
/**
 * Write a description of class RailFence here.
 * 
 * @author Abid Ahmed
 * @version 6-5-17
 */
public class RailFence extends TranspositionCipher
{
   private String myMessage;
   private int myRows;
   
   public RailFence(String message, int numRows) {
       myMessage = cleanMessage(message);
       myRows = numRows;
   }
   
   public String encrypt() {
       if (myRows == 0) {
           return myMessage;
       }
       String[][] table = new String[myRows][myMessage.length()];
       // Fill the table with empty strings
       for (int i = 0; i < table.length; i++) {
           for (int j = 0; j < table[0].length; j++) {
               table[i][j] = "";
           }
       }
       // Fill the array with the message
       table[0][0] = myMessage.substring(0, 1);
       int row = 1;
       int place = 1;
       int prev = 0;
       for (int j = 1; j < table[0].length; j++) {
           table[row][j] = myMessage.substring(place, place+1);
           place++;
           int temp = row;
           if (row == 0) {
               row++; 
           } else if (row == myRows-1) {
               row--;
           } else if (row > prev) {
               row++;
           } else if (row < prev) {
               row--;
           } 
           prev = temp;
       }
       // Get the cipher text
       String cipherText = "";
       for (int i = 0; i < table.length; i++) {
           for (int j = 0; j < table[0].length; j++) {
               cipherText += table[i][j];
           }
       }
       return format(cipherText);
   }
   
   public String decrypt() {
       if (myRows == 0) {
           return myMessage;
       }
       String[][] table = new String[myRows][myMessage.length()];
       // Fill the table with empty strings
       for (int i = 0; i < table.length; i++) {
           for (int j = 0; j < table[0].length; j++) {
               table[i][j] = "0";
           }
       }
       // Fill the table with the cipher text
       int place = 0;
       int gap = findGap(myRows);
       for (int i = 0; i < table.length; i++) {
           if (i == 0 || i == myRows-1) {
               for (int j = i; j < table[0].length; j += gap) {
                   if (place < myMessage.length()) {
                       table[i][j] = myMessage.substring(place, place+1);
                       place++;
                   }
               }
           } else if ((i <= myRows/2+1 && myRows%2 == 1) || (i <= myRows/2 && myRows%2 == 0)) {
               for (int j = i; j < table[0].length; j += (gap - (gap - 2*i))) {
                  if (place < myMessage.length()) {
                      table[i][j] = myMessage.substring(place, place+1);
                      place++;
                  } else {
                      break;
                  }
                  if (j + (gap - 2*i) < myMessage.length() && place < myMessage.length()) {
                       j += (gap - 2*i);
                       table[i][j] = myMessage.substring(place, place+1);
                       place++;
                  } else {
                      break;
                  }
               }
           } else {
               for (int j = i; j < table[0].length; j += (gap - (gap-2*i))) {
                  if (place < myMessage.length()) {
                      table[i][j] = myMessage.substring(place, place+1);
                      place++;
                  }
                  if (j + (gap - 2*i) < myMessage.length() && place < myMessage.length()) {
                       j += (gap - 2*i);
                       table[i][j] = myMessage.substring(place, place+1);
                       place++;
                  } else {
                      break;
                  }
               }
           }
       }
       // Get original message
       String message = "";
       message += table[0][0];
       int row = 1;
       int prev = 0;
       for (int j = 1; j < table[0].length; j++) {
           message += table[row][j];
           int temp = row;
           if (row == 0) {
               row++; 
           } else if (row == myRows-1) {
               row--;
           } else if (row > prev) {
               row++;
           } else if (row < prev) {
               row--;
           } 
           prev = temp;
       }
       return message;
   }
   
   // This helper method will find the distance between the peaks/troughs of the zigzag
   public int findGap(int rows) {
      if (rows == 1) {
          return 0;
      } else if (rows == 2) {
          return 2;
      } else {
          return 4 + findGap(rows-2);
      }
   }
}
