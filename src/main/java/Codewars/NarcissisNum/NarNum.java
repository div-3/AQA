package Codewars.NarcissisNum;

import org.example.Main;

import java.util.ArrayList;

/*A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised to
 the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).

For example, take 153 (3 digits), which is narcissistic:

    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
and 1652 (4 digits), which isn't:

    1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938
The Challenge:

Your code must return true or false (not 'true' and 'false') depending upon whether the given number is a Narcissistic number in base 10.

This may be True and False in your language, e.g. PHP.

Error checking for text strings or other invalid inputs is not required, only valid positive non-zero integers will be passed into the function.*/
public class NarNum {

    /*A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits,
    each raised to the power of the number of digits in a given base.

    For example, take 153 (3 digits), which is narcissistic:
    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    and 1652 (4 digits), which isn't:
    1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938*/
    public static boolean isNarcissistic(int number) {
        int sum = 0;
        String numStr = Integer.toString(number);
        for (int i = 0; i < numStr.length(); i++) {
            sum += Math.pow( Double.parseDouble( String.valueOf( numStr.charAt(i) )), numStr.length());
        }
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(NarNum.isNarcissistic(153));
        System.out.println(NarNum.isNarcissistic(1634));
        System.out.println(NarNum.isNarcissistic(112));
    }
}
