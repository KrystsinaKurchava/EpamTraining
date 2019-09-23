package Fundamentals.OptionTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OptionTest {
    public static void main(String[] args) {
        String[] line = randomNumber();
        longerShorter(line);
        Sort(line);
        differetneValue(line);
    }

    private static String[] randomNumber() {
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

    private static void longerShorter(String value[]) {
        int longer = 0;
        int shorter = 1000;
        String shorter_name = null;
        String longer_name = null;
        for (String count : value) {
            if (count.length() < shorter) {
                shorter = count.length();
                shorter_name = count;
            }
            if (count.length() > longer) {
                longer = count.length();
                longer_name = count;
            }

        }
        System.out.println("Самое короткое число " + shorter_name + " состоит из " + shorter + " цифр");
        System.out.println("Самое длинное число " + longer_name + " состоит из " + longer + " цифр");
    }

    //  Вывести числа в порядке возрастания значений их длины.
    private static void Sort(String value[]) {
        Arrays.sort(value, new Comparator<String>() {
            public int compare(String count1, String count2) {
                return count1.length() - count2.length();
            }
        });
        System.out.println(Arrays.asList(value));
    }

    //определить количество чисел состоящих из лишь четных цифр
    // из оствашихся - с равным количеством четных и нечетных
    private static void differetneValue(String value[]) {
        int numberOfEven = 0;
        int numberOfOdd = 0;
        for (String valueCount : value) {
            int amountOfEvennless = 0;
            for (int i = 0; i < valueCount.length(); i++) {
                String resultLine = String.valueOf(valueCount.charAt(i));
                Integer number = Integer.valueOf(resultLine);
                if (number % 2 == 0) {
                    amountOfEvennless++;
                }
            }
            if (amountOfEvennless == valueCount.length()) {
                numberOfEven++;
            } else if (amountOfEvennless * 2 == valueCount.length()) {
                numberOfOdd++;
            }
        }
        System.out.println("Количество чисел, состоящих из полностью четных цифр: " + numberOfEven);
        System.out.println("Количество чисел, состоящих из равного количества четных и нечетных цифр: " + numberOfOdd);
    }
}

