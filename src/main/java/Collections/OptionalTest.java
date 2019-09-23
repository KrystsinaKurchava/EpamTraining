package Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class OptionalTest {
    public static void main(String[] args) {
        int length = 5;
        ArrayList list = randomList(length);
        System.out.println(list);
        sortPositiveAndNegative(list);
        System.out.println(list);
        String nameOfPoem = "data/poem.txt";
        poemString(nameOfPoem);
        differentWords(nameOfPoem);
        sortLine(nameOfPoem);
        parenthesesChoice("data/parentheses.txt");
    }

    private static ArrayList randomList(int length) {
        ArrayList<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(i, (int) (Math.random() * 30) - 15);
        }
        return list;
    }

    private static void sortPositiveAndNegative(ArrayList list) {
        Collections.sort(list);

    }

    private static void poemString(String name) {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader stream = new BufferedReader(new FileReader(name));) {
            while ((line = stream.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        list.forEach(System.out::println);

    }

    private static void differentWords(String name) {
        Set<String> list = new HashSet<>();
        String line;

        try (BufferedReader stream = new BufferedReader(new FileReader(name));) {
            while ((line = stream.readLine()) != null) {
                String[] retval = line.split("[ ,.;?]");
                for (int i = 0; i < retval.length; i++) {
                    list.add(retval[i].toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }

    private static void sortLine(String name) {
        List<String> list = new ArrayList<>();
        String line;
        try (BufferedReader stream = new BufferedReader(new FileReader(name));) {
            while ((line = stream.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println("----------------------------------------");
        list.forEach(System.out::println);

    }

    private static void parenthesesChoice(String name) {
        Stack stack = new Stack();
        String line;
        try (BufferedReader stream = new BufferedReader(new FileReader(name))) {
            while ((line = stream.readLine()) != null) {
                char[] retval = line.toCharArray();
                for (int i = 0; i < retval.length; i++) {
                    char parentheses = retval[i];
                    switch (parentheses) {
                        case '(':
                            stack.push(parentheses);
                            break;
                        case '[':
                            stack.push(parentheses);
                            break;
                        case '{':
                            stack.push(parentheses);
                            break;
                        case ')':
                            if (!stack.isEmpty() && stack.peek().equals('(')) {
                                stack.pop();
                            } else {
                                stack.push(parentheses);
                            }
                            break;
                        case ']':
                            if (!stack.isEmpty() && stack.peek().equals('[')) {
                                stack.pop();
                            } else {
                                stack.push(parentheses);
                            }
                            break;
                        case '}':
                            if (!stack.isEmpty() && stack.peek().equals('{')) {
                                stack.pop();
                            } else {
                                stack.push(parentheses);
                            }
                            break;
                        default:
                            stack.push('x');
                            break;
                    }
                }
                if (stack.empty()) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                    stack.clear();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
