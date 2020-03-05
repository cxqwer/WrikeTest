package utilities;

import java.util.Random;

public class GeneratedEmail {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final int STR_LENGTH = 9;
    private static final String MASK = "wpt@wriketask.qaa";

    public static String createRandomEmail(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(CHARS.length());
            char ch = CHARS.charAt(number);
            builder.append(ch);
        }
        return builder.toString()+MASK;
    }
}
