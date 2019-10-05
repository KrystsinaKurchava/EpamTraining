package fundamentals;

import java.util.Random;
import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {

        printHelloUser();
        chooseByMonth();

        int[] array = getRandomNumber();
        showMyRandomNumberInOneLine(array);
        showMyRandomNumberInNewLine(array);

        System.out.println("Количество аргументов " + args.length);
        for (int i = args.length - 1; i > -1; i--) {
            System.out.println(args[i]);
        }

        int sum = 0;
        int product = 1;
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            int argumentsCommandLine = Integer.parseInt(args[i]);
            sum = sum + argumentsCommandLine;
            product = product * argumentsCommandLine;
        }
        System.out.println("Произведение аргументов равно: " + product);
        System.out.println("Сумма аргументов равна: " + sum);

    }

    private static void printHelloUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String name = in.nextLine();
        System.out.println("Добро пожаловать, " + name);
    }

    private static int[] getRandomNumber() {
        Random randomName = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество случайных цифр: ");
        int count = in.nextInt();
        int[] value = new int[count];
        for (int i = 0; i < value.length; i++) {
            value[i] = randomName.nextInt();
        }
        return value;
    }

    private static void showMyRandomNumberInOneLine(int[] value) {
        System.out.print("Вывод случаных цифр без перехода на новую строку: ");
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }
        System.out.println();
    }

    private static void showMyRandomNumberInNewLine(int[] value) {
        System.out.println("Вывод случаных цифр с переходом на новую строку: ");
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i] + " ");
        }
    }

    private static void chooseByMonth() {
        System.out.println("Введите номер месяца");
        do {
            String month;
            Scanner in = new Scanner(System.in);
            try {
                int numberOfMonth = in.nextInt();
                if (numberOfMonth < 1 || numberOfMonth > 12) {
                    System.out.println("от 1 до 12");
                    continue;
                }
                switch (numberOfMonth) {
                    case 1:
                        month = "Январь";
                        break;
                    case 2:
                        month = "Февраль";
                        break;
                    case 3:
                        month = "Март";
                        break;
                    case 4:
                        month = "Апрель";
                        break;
                    case 5:
                        month = "Май";
                        break;
                    case 6:
                        month = "Июнь";
                        break;
                    case 7:
                        month = "Июль";
                        break;
                    case 8:
                        month = "Август";
                        break;
                    case 9:
                        month = "Сентябрь";
                        break;
                    case 10:
                        month = "Октябрь";
                        break;
                    case 11:
                        month = "Ноябрь";
                        break;
                    case 12:
                        month = "Декабрь";
                        break;
                    default:
                        month = "Некорректное ввод. Попробуйте еще раз";
                        break;
                }
                System.out.println(month);
                return;
            } catch (Exception ex) {
                System.out.println("Некорректное ввод. Введите число");
            }

        } while (true);

    }
}





