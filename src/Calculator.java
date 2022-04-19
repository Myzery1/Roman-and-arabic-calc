import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    static int number1;
    static int number2;
    static int result;
    static String action;

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        System.out.println("Введите арабские или римские цифры в " +
                "формате число, оператор, число, разделяя пробелом");
        System.out.println("Операторы: +, -, *, / ");
        Scanner sc = new Scanner(System.in);
        String firstNum;
        String secondNum;
        // проверка на мат операцию
        try {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            firstNum = strings[0];
            secondNum = strings[2];
            action = strings[1];
            if (strings.length <= 2) {
                throw new IOException("Строка не является математической операцией");
            }
            if (strings.length > 3) {
                throw new IOException("Формат математической " +
                        "операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}

            String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            // проверка на римские цифры в массиве римских чисел
            if ((Arrays.asList(rome).contains(firstNum)) && (Arrays.asList(rome).contains(secondNum))) {
                number1 = convert1(firstNum);
                number2 = convert2(secondNum);
                result = calc(action, number1, number2);
                // проверка на отрицательные значения в римском
                if (result > 0) {
                    System.out.println(convertToRoman(result));
                } else throw new IOException("В римской системе нет нуля или отрицательных чисел");
                // проверка на арабские цифры в массиве арабских чисел
            } else if ((Arrays.asList(arab).contains(firstNum)) && (Arrays.asList(arab).contains(secondNum))) {
                number1 = Integer.parseInt(firstNum);
                number2 = Integer.parseInt(secondNum);
                result = calc(action, number1, number2);
                System.out.println(result);
                // исключения на разные системы счислений или число вне 1-10
            } else {
                throw new IOException("Используются одновременно разные системы счисления");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Строка не является математической операцией");
        }
    }

    private static int convert1(String firstNum) {
        int pos1 = 0;
        String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String i : rome) {
            pos1++;
            if (firstNum.equals(i)) {
                number1 = pos1;
            }
        }
        return number1;
    }

    private static int convert2(String secondNum) {
        int pos2 = 0;
        String[] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String j : rome) {
            pos2++;
            if (secondNum.equals(j)) {
                number2 = pos2;
            }
        }
        return number2;
    }

    public static int calc(String action, int number1, int number2) {
        int result = 0;
        switch (action) {
            case "+": {
                result = number1 + number2;
                break;}
            case "-": {
                result  = number1 - number2;
                break;}
            case "*": {
                result = number1 * number2;
                break;}
            case "/": {
                result = number1 / number2;
                break;
            }
            default: {
                // проверка на присутствие действия (+ - * / )
                System.out.println("Строка не является математической операцией");
            }
        }
        return result;
    }

    public static String convertToRoman(int result) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[result];
        return s;
    }
}