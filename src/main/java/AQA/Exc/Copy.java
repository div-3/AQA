package AQA.Exc;

import java.io.IOException;
import java.nio.file.Path;

public class Copy {
    public static void main(String[] args) {
        Path pathFrom = Path.of("D:\\Ivan\\!QA\\AQA\\src\\main\\java\\AQA\\Exc\\doc.txt");
//        Path pathTo = Path.of("D:\\Ivan\\!QA\\AQA\\src\\main\\java\\AQA\\Exc\\doc1.txt");
        Path pathTo = null;
        try {
            Copier.copyTextFile(pathFrom, pathTo);
        } catch (IOException e) {
            System.out.println("Что-то пошло не так: " + e.toString());
        }
         catch (RuntimeException r) {
            System.out.println(r.toString());
        }
    }
}
