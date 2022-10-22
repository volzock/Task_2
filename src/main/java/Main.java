import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static String repeat(String s, int count) {
        return s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(string -> string.repeat(count))
                .collect(Collectors.joining());
    }

    public static int differenceMaxMin(int [] array) {
        if (array.length > 0) {
            return Math.abs(Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt());
        }
        return 0;
    }

    public static boolean isAvgWhole(int [] array) {
        if (array.length == 0) {
            return true;
        }
        return IntStream.of(array).sum() % array.length == 0;
    }

    public static int [] cumulativeSum(int [] array) {
        int[] newArray = Arrays.copyOf(array, array.length);

        if (newArray.length >= 2) {
            for (int i = 1; i < newArray.length; ++i) {
                newArray[i] += newArray[i - 1];
            }
        }

        return newArray;
    }

    public static int getDecimalPlaces(String s) {
        try {
            return s.split("\\.")[1].length();
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public static int Fibonacci(int number) {
        int[] buff = {1, 1, 0};
        if (number > 2) {
            for (int i = 1; i < number; ++i) {
                buff[2] = buff[0] + buff[1];
                buff[0] = buff[1];
                buff[1] = buff[2];
            }
        }
        return buff[2];
    }

    public static boolean isValid(String postIndex) {
        return postIndex.matches("\\d{5}");
    }

    public static boolean isStrangePair(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        return s1.charAt(0) == s2.charAt(s2.length() - 1) && s1.charAt(s1.length() - 1) == s2.charAt(0);
    }

    public static boolean isPrefix(String s, String prefix) {
        return s.startsWith(prefix.replace("-", ""));
    }

    public static boolean isPostfix(String s, String postfix) {
        return s.endsWith(postfix.replace("-", ""));
    }

    public static int boxSeq(int number) {
        return (number + 1)/2*3 - number/2;
    }

    public static int[] getIntArray(Scanner scanner) {
        return Arrays.stream(scanner.next().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            int numOfTask = scanner.nextInt();

            switch (numOfTask) {
                case 1:
                    System.out.println(repeat(scanner.next(), scanner.nextInt()));
                    break;
                case 2:
                    System.out.println(differenceMaxMin(getIntArray(scanner)));
                    break;
                case 3:
                    System.out.println(isAvgWhole(getIntArray(scanner)));
                    break;
                case 4:
                    System.out.println(Arrays.toString(cumulativeSum(getIntArray(scanner))));
                    break;
                case 5:
                    System.out.println(getDecimalPlaces(scanner.next()));
                    break;
                case 6:
                    System.out.println(Fibonacci(scanner.nextInt()));
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println(isValid(scanner.nextLine()));
                    break;
                case 8:
                    System.out.println(isStrangePair(scanner.next(), scanner.next()));
                    break;
                case 9:
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println(isPrefix(scanner.next(), scanner.next()));
                            break;
                        case 2:
                            System.out.println(isPostfix(scanner.next(), scanner.next()));
                            break;
                        default:
                            throw new IllegalArgumentException("There's no subtask with such number");
                    }
                    break;
                case 10:
                    System.out.println(boxSeq(scanner.nextInt()));
                    break;
                default:
                    throw new IllegalArgumentException("There's no task with such number");
            }
        }
    }
}
