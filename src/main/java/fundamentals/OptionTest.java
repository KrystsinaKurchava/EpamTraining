package fundamentals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OptionTest {
    public static void main(String[] args) {
        String[] line = getRandomNumber();
        findLongerOrShorterNumber(line);
        sortNumberByLength(line);
        getCountEvenAndOddNumber(line);
    }

    private static String[] getRandomNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество случайных цифр: ");
        int count = in.nextInt();
        System.out.println("Введите случайные цифры: ");
        String[] value = new String[count];
        for (int i = 0; i < value.length; i++) {
            value[i] = in.next();
        }
        return value;
    }

    private static void findLongerOrShorterNumber(String value[]) {
        int primaryLongestName = 0;
        int primaryShortestName = 1000;
        String shorterName = null;
        String longerName = null;
        for (String count : value) {
            if (count.length() < primaryShortestName) {
                primaryShortestName = count.length();
                shorterName = count;
            }
            if (count.length() > primaryLongestName) {
                primaryLongestName = count.length();
                longerName = count;
            }

        }
        System.out.println("Самое короткое число " + shorterName + " состоит из " + primaryShortestName + " цифр");
        System.out.println("Самое длинное число " + longerName + " состоит из " + primaryLongestName + " цифр");
    }

    private static void sortNumberByLength(String value[]) {
        Arrays.sort(value, new Comparator<String>() {
            public int compare(String count1, String count2) {
                return count1.length() - count2.length();
            }
        });
        System.out.println(Arrays.asList(value));
    }

    private static void getCountEvenAndOddNumber(String value[]) {
        int numberOfEven = 0;
        int numberOfOdd = 0;
        for (String valueCount : value) {
            int amountOfEvenness = 0;
            for (int i = 0; i < valueCount.length(); i++) {
                String resultLine = String.valueOf(valueCount.charAt(i));
                Integer number = Integer.valueOf(resultLine);
                if (number % 2 == 0) {
                    amountOfEvenness++;
                }
            }
            if (amountOfEvenness == valueCount.length()) {
                numberOfEven++;
            } else if (amountOfEvenness * 2 == valueCount.length()) {
                numberOfOdd++;
            }
        }
        System.out.println("Количество чисел, состоящих из полностью четных цифр: " + numberOfEven);
        System.out.println("Количество чисел, состоящих из равного количества четных и нечетных цифр: " + numberOfOdd);
    }
}

