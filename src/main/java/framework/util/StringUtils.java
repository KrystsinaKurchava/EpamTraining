package framework.util;

import java.util.Random;

public class StringUtils {
    private static final int MIN_STRING_LENGTH = 4;
    private static final int MAX_STRING_LENGTH = 10;
    private static final String ALFANUMERICAL_ALL_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    public static String getRandomString() {
        int stringLength = random.nextInt(MAX_STRING_LENGTH);
        stringLength = stringLength < MIN_STRING_LENGTH ? MIN_STRING_LENGTH : stringLength;
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS
                    .charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }
}