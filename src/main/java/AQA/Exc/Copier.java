package AQA.Exc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*1. Выброс исключения
Создайте класс Copier со статическим методом copyTextFile
Метод должен принимать на вход путь до файла, который копируем и путь для нового файла
Метод должен вычитывать все строки из переданного файла и сохранять в новый файл
Метод должен выбрасывать (throws) IOException
В отдельном классе создайте метод psvm
Вызовите метод copyTextFile. Файл-источник - этот файл с заданием. Файл для сохранения укажите любой.
Оберните вызов в try/catch
В блоке catch напечатайте в консоль "Что-то пошло не так"
Примеры работы с файлами

Files.readAllLines(Path.of("")); //вычитать строки из файла
Files.writeString(Path.of(""), text_here); // записать текст в файл*/
public class Copier {

    public static void copyTextFile(Path pFrom, Path pTo) throws IOException, RuntimeException {
        if (pFrom == null || pTo ==null) throw new RuntimeException("Неверный путь!");
        List<String> buf = Files.readAllLines(pFrom, Charset.forName("windows-1251"));
        Files.write(pTo, buf);
    }
}
