package QA;

import java.util.Arrays;
import java.util.HashSet;

/*Пользователь вводит набор чисел в виде одной строки "1, 2, 3, 4, 4, 5".
Избавиться от повторяющихся элементов в строке.Вывести результат на экран*/
public class L10Collections {
    public static void main(String[] args) {
        String str = "1, 2, 2, 3, 4, 4, 5, 2";
        System.out.println("Исходная последовательность чисел в виде строки: " + str);
        String[] strArr = str.replaceAll(" ", "").split(",");
        //Перенос из массива строк в HashSet
        HashSet<String> hsString = new HashSet<>(Arrays.asList(strArr));

        //или
//        HashSet<String> hsString = new HashSet<>();
//        for (String s : strArr) {
//            hsString.add(s);
//        }

        //или
//        HashSet<String> hsString = new HashSet<>();
//        hsString.addAll(Arrays.asList(strArr));

        //Формирование строки с результатом
        String result = hsString
                .toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "");
        System.out.println("Отфильтрованная последовательность чисел в виде строки: " + result);
    }
}
