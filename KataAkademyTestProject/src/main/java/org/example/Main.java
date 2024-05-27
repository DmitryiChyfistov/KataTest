package org.example;
import java.util.Scanner;

public class Main {
    static String[] romanNumerals = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
            "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
            "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
            "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",
    };


    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println(parse());
        }
    }

    public static int parse() throws Exception {
        while (true) {
            System.out.println("Введите целых числа (арабских или римских)");
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine();
            int result = 0;
            int num1;
            int num2;
            String[] operands = expression.split(" ");
            if(operands.length > 3) {
                throw new Exception("Не корректно введены данные");
            }
            if ((isRoman(operands[0]) && isRoman(operands[2]))) {
                if ((operands[0].length() < operands[2].length()) && (operands[1].equals("-"))) {
                    throw new Exception("Значение не может быть отрицательным в римских цифрах");
                }
            }

            if ((isRoman(operands[0]) && isRoman(operands[2]))) {
                if (operands[1].equals("*"))
                        System.out.println(romanNumerals[(number(operands[0]) * (number(operands[2])))]);
                    }
            if ((isRoman(operands[0]) && isRoman(operands[2]))) {
                if (operands[1].equals("+"))
                    System.out.println(romanNumerals[(number(operands[0]) + (number(operands[2])))]);
            }


            if ((isRoman(operands[0]) && isRoman(operands[2]))) {
                if (operands[1].equals("/")) {
                    try {
                        System.out.println(romanNumerals[(number(operands[0]) / (number(operands[2])))]);
                    }catch (Exception e) {
                        throw new Exception("Число не может быть дробным");
                    }
                }
            }

            if ((!isRoman(operands[0]) && isRoman(operands[2])) || (isRoman(operands[0]) && !isRoman(operands[2]))) {
                throw new Exception("Не правльно введены значения");

            }
            if ((!isRoman(operands[0]) && !isRoman(operands[2]))) {
                num1 = Integer.parseInt(operands[0]);
                num2 = Integer.parseInt(operands[2]);
                if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
                    throw new Exception("Заданое число не в диапазоне от 1 до 10");
                }
                if (expression.contains("+")) {
                    result = num1 + num2;
                }
                if (expression.contains("-")) {
                    result = num1 - num2;
                }
                if (expression.contains("*")) {
                    result = num1 * num2;
                }
                if (expression.contains("/")) {
                    result = num1 / num2;
                }
                return result;
            }
        }
    }

    public static boolean isRoman(String num) {
        for (int i = 0; i < romanNumerals.length; i++) {
            if (num.equals(romanNumerals[i])) {
                return true;
            }
        }
        return false;
    }

    public static int number(String num) {
        int number = 0;
        for (int i = 0; i < romanNumerals.length; i++) {
            if (num.equals(romanNumerals[i])) {
                number = i;
                return number;
            }
        }
        return number;
    }
}
