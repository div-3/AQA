package Codewars.PersistentBugger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/* Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
which is the number of times you must multiply the digits in num until you reach a single digit.
For example (Input --> Output):
39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
4 --> 0 (because 4 is already a one-digit number)*/
public class PersistentBugger {

    /*Разобраться с рекурсией
    * 	public static int persistence(long n) {
		long m = 1, r = n;

    if (r / 10 == 0)
      return 0;

    for (r = n; r != 0; r /= 10)
      m *= r % 10;

    return persistence(m) + 1;

	}*/
    public static int persistence(long n) {
//        String str = Long.toString(n);
//        long mul = 0;
//        int counter = 0;
//        while (str.length() > 1){
//            mul = 1;
//            for (int i = 0; i < str.length(); i++){
//                mul *= Long.parseLong(String.valueOf(str.charAt(i)));
//            }
//            str = Long.toString(mul);
//            counter++;
//        }
//        return counter;

        //Решение от ChatGPT (максимально короткое)
        return n < 10 ? 0 : 1 + persistence(Long.toString(n).chars().reduce(1, (a, b) -> a * (b - '0')));

        /*Решение от ChatGPT (максимально быстрое)
        public static int persistence(long n) {
            int count = 0;
            while (n > 9) {
                long temp = 1;
                while (n != 0) {
                    temp *= n % 10;
                    n /= 10;
                }
                n = temp;
                count++;
            }
            return count;
        }
        ```
            В этой версии кода мы используем обычный цикл while, который оптимизирован для работы с целыми числами.
             Проверка на значение числа < 10 заменена на более быструю и правильную проверку на значение числа > 9.
              Внутри цикла вместо String методов используются математические операции для вычисления произведения
               цифр числа в переменной temp. Также мы изменили название временной переменной на temp,
               чтобы избежать перекрытия с встроенной функцией Math. Использование циклов while и математических
               операций позволяет значительно ускорить выполнение данной задачи.*/
    }

    public static void main(String[] args) {

    }

    @Test
    public void basicTests() {
        assertEquals(3, PersistentBugger.persistence( 39), "Incorrect answer for n=39" );
        assertEquals(0, PersistentBugger.persistence(  4), "Incorrect answer for n=4"  );
        assertEquals(2, PersistentBugger.persistence( 25), "Incorrect answer for n=25" );
        assertEquals(4, PersistentBugger.persistence(999), "Incorrect answer for n=999");
    }
}
