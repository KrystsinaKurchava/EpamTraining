package Fundamentals.MainTask;

import java.util.Random;
import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {
        //Приветствие пользователя
        hello();
       /*Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
        Осуществить проверку корректности ввода чисел.*/
        mounthChoose();
        /*Вывод случайных чисел без перехода на новую
        строку и с переходом*/
        int[] array = randomNumber();
        showMyArrayinLine(array);
        showMyArrayinNewLine(array);
        //Отобразить в окне консоли аргументы командной строки в обратном порядке.
        System.out.println("Количество аргументов " + args.length);
        for (int i = args.length - 1; i > -1; i--) {
            System.out.println(args[i]);
        }
        /* Ввести целые числа как аргументы командной строки,
        подсчитать их сумму (произведение) и вывести результат на консоль. */
        int sum = 0;
        int product = 1;
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
            int argumentsCommanLine = Integer.parseInt(args[i]);
            sum = sum + argumentsCommanLine;
            product = product * argumentsCommanLine;
        }
        System.out.println("Произведение аргументов равно: " + product);
        System.out.println("Сумма аргументов равна: " + sum);

    }

    private static void hello() {
        Scanner in = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String name = in.nextLine();
        System.out.println("Добро пожаловать, " + name);
    }

    private static int[] randomNumber() {
        Random rd = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество случайных цифр: ");
        int count = in.nextInt();
        int[] value = new int[count];
        for (int i = 0; i < value.length; i++) {
            value[i] = rd.nextInt();
        }
        return value;
    }

    private static void showMyArrayinLine(int[] value) {
        System.out.print("Вывод случаных цифр без перехода на новую строку: ");
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }
        System.out.println();
    }

    private static void showMyArrayinNewLine(int[] value) {
        System.out.println("Вывод случаных цифр с переходом на новую строку: ");
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i] + " ");
        }
    }

    private static void mounthChoose() {

        System.out.println("Введите номер месяца");
        do {
            String mounth;
            Scanner in = new Scanner(System.in);
            try {
                int numberOfMounth = in.nextInt();
                if (numberOfMounth < 1 || numberOfMounth > 12) {
                    System.out.println("от 1 до 12");
                    continue;
                }
                switch (numberOfMounth) {
                    case 1:
                        mounth = "Январь";
                        break;
                    case 2:
                        mounth = "Февраль";
                        break;
                    case 3:
                        mounth = "Март";
                        break;
                    case 4:
                        mounth = "Апрель";
                        break;
                    case 5:
                        mounth = "Май";
                        break;
                    case 6:
                        mounth = "Июнь";
                        break;
                    case 7:
                        mounth = "Июль";
                        break;
                    case 8:
                        mounth = "Август";
                        break;
                    case 9:
                        mounth = "Сентябрь";
                        break;
                    case 10:
                        mounth = "Октябрь";
                        break;
                    case 11:
                        mounth = "Ноябрь";
                        break;
                    case 12:
                        mounth = "Декабрь";
                        break;
                    default:
                        mounth = "Некорректное ввод. Попробуйте еще раз";
                        break;
                }
                System.out.println(mounth);
                return;
            } catch (Exception ex) {
                System.out.println("Некорректное ввод. Введите число");
            }

        } while (true);

    }
}





