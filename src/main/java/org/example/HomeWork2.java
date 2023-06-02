package org.example;

public class HomeWork2 {
    /*
    * - Используя sout, зучить, что делают методы:
    -- .trim()
    -- .charAt(0)
    -- .charAt(1)
    -- .charAt(2)
    -- .toLowerCase()
    -- .toUpperCase()
    -- .concat(" Пока!")
    -- .contains(" ")
    -- .startsWith("Привет")
    -- .endsWith("мир!")
    -- .indexOf("е")
    -- .lastIndexOf("е")
    -- .isEmpty()
    -- .isBlank()
    -- .length()
    -- .repeat(12)
    -- .substring(1, 5)
    -- .replace("мир", "МИР")*/

    public static void main(String[] args) {
        String str = "  \t \n Привет Мир!\n \t    ";
        System.out.println("Исходный: " + str);
        System.out.println("1. .strip(): " + str.strip()); // .strip() - обрезает пробелы, табуляции и др. непечатаемые символы в начале и конце строки
        System.out.println("2. .trim(): " + str.trim()); // .trim() - обрезает пробелы в начале и конце строки
        str = str.trim();
        System.out.println("3. .charAt(0): " + str.charAt(0));      // .charAt(0) - символ в позиции 0
        System.out.println("4. .charAt(5): " + str.charAt(5));      // .charAt(0) - символ в позиции 0
        System.out.println("5. .charAt(7): " + str.charAt(7));      // .charAt(0) - символ в позиции 0
        System.out.println("6. .toLowerCase(): " + str.toLowerCase());      // .toLowerCase() - все маленькие буквы
        System.out.println("7. .toUpperCase(): " + str.toUpperCase());      // .toUpperCase() - все большие буквы
        System.out.println("8. .concat(\"Пока!\"): " + str.concat("Пока!"));      // .concat(str) - добавляет текст к строке
        System.out.println("9. .contains(\" \"): " + str.contains(" "));      // .contains(str) - true, если искомый текст есть в строке, иначе false
        System.out.println("10. .startsWith(\"Привет\"): " + str.startsWith("Привет"));      // .startsWith(str) - true, если искомый текст есть в начале строки, иначе false
        System.out.println("11. .endsWith(\"Мир!\"): " + str.endsWith("Мир!"));      // .endsWith(str) - true, если искомый текст есть в конце строки, иначе false
        System.out.println("12. .indexOf(\"р\"): " + str.indexOf("р"));      // .indexOf(str) - возвращает позицию искомого текста в строке
        System.out.println("13. .lastIndexOf(\"р\"): " + str.lastIndexOf("р"));      // .lastIndexOf(str) - возвращает позицию искомого текста в строке при поиске с конца, если не найден, то возвращает -1
        System.out.println("14. .length(): " + str.length());      // .length() - возвращает длину строки
        System.out.println("15. .repeat(5): " + str.repeat(5));      // .repeat(int) - повторяет строку указанное количество раз
        System.out.println("16. .substring(5, 10): " + str.substring(5, 10));      // .substring(x, y) - возвращает часть строки между x и y символами
        System.out.println("17. .replace(\"Мир\", \"МИР\"): " + str.replace("Мир", "МИР"));      // .replace(str1, str2) - ищет в строке все указанные str1 и заменяет их на str2

        String str2 = " ";
        System.out.println("Исходный текст: \" \"");
        System.out.println("18. .isEmpty(): " + str2.isEmpty());      // .isEmpty() - true, если строка пустая или null, иначе false
        System.out.println("19. .isBlank(): " + str2.isBlank());      // .isBlank() - true, если строка пустая или null, или пробел (" "), или табуляция, иначе false


    }
}
