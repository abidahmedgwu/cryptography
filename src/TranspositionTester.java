
/**
 * Write a description of class TranspositionTester here.
 * 
 * @author Abid Ahmed
 * @version 5-30-17
 */
public class TranspositionTester
{
    public static void main(String[] args) {
        TranspositionCipher test1 = new ColumnarTransposition("We confirm the delivery of the documents x", "ALADIN");
        System.out.println(test1.encrypt());
        
        TranspositionCipher test2 = new ColumnarTransposition(test1.encrypt(), "ALADIN");
        System.out.println(test2.decrypt());
        System.out.println();
        
        TranspositionCipher test3 = new DoubleTransposition("We confirm the delivery of the documents x", "ALADIN", "Conspiracy");
        System.out.println(test3.encrypt());
        
        TranspositionCipher test4 = new DoubleTransposition(test3.encrypt(), "ALADIN", "CONSPIRACY");
        System.out.println(test4.decrypt());
        System.out.println();
        
        TranspositionCipher test5 = new DisruptedTransposition("We confirm the delivery of the documents and will send further instructions x", "conspiracy");
        System.out.println(test5.encrypt());
        
        TranspositionCipher test6 = new DisruptedTransposition(test5.encrypt(), "CONSPIRACY");
        System.out.println(test6.decrypt());
        System.out.println();
        
        TranspositionCipher test7 = new DisruptedTransposition("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "TESTING");
        System.out.println(test7.encrypt());
        
        TranspositionCipher test8 = new DisruptedTransposition(test7.encrypt(), "Testing");
        System.out.println(test8.decrypt());
        System.out.println();
        
        TranspositionCipher test9 = new RailFence("Defend the east wall", 3);
        System.out.println(test9.encrypt());
        
        TranspositionCipher test10 = new RailFence(test9.encrypt(), 3);
        System.out.println(test10.decrypt());
        System.out.println();
        
        TranspositionCipher test11 = new RailFence("DEFEND THE EAST WALL", 9);
        System.out.println(test11.encrypt());
        System.out.println(((RailFence)test11).findGap(9));
        
        TranspositionCipher test12 = new RailFence(test11.encrypt(), 9);
        System.out.println(test12.decrypt());
    }
}
