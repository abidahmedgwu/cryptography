/**
 * Created by aahme on 8/4/2017.
 */
public class GeneratorTester {
    public static void main(String[] args) {
        Generator gen = new Generator();
        System.out.println(gen.generatePassword(16, "Test").getEncryptedPassword());
    }
}
