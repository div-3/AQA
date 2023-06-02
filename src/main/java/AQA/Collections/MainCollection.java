package AQA.Collections;

import java.util.ArrayList;
import java.util.List;

public class MainCollection {
    public static void main(String[] args) {

        //Правильное и неправильное стравнение объектов
        Player p1 = new Player(1, "Cheater", true);
        Player p2 = new Player(1, "Cheater", true);

        System.out.println("Сравнение игроков через \"==\": " + (p1 == p2));
        System.out.println("Сравнение игроков через \"equals\": " + p1.equals(p2));

        System.out.println("-----------------------------------------------------------");
        //Список дел
        List<String > toDoList = new ArrayList<>();
        toDoList.add("ДЗ по AQA");
        toDoList.add("ДЗ по QA");
        toDoList.add("Купить ракетки для бадминтона");
        toDoList.add("Сходить в спортзал");
        toDoList.add("Webinar по AQA");

        System.out.println("Список дел:");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println("Задача " + (i + 1) + ": " + toDoList.get(i));
        }

        System.out.println("-----------------------------------------------------------");
        //Список фильмов
        List<Movie> myFilms = new ArrayList<>();
        myFilms.add(new Movie("Звёздный десант", 8, "Фантастика", "США", false));
        myFilms.add(new Movie("Последняя фантазия", 8, "Аниме", "США", false));
        myFilms.add(new Movie("Грань будущего", 8, "Боевик", "Канада", false));

        System.out.println("Мои фильмы:");
        for (Movie m : myFilms) {
            System.out.println(m.toString());
        }

        System.out.println("-----------------------------------------------------------");
        //Список кинокомпаний и их фильмов
        List<Company> companies = new ArrayList<>();
        List<Movie> m = new ArrayList<>();
        m.add(0, new Movie("Безумная свадьба", 8, "Романтическая комедия", "Южная Корея", false));
        m.add(1, new Movie("Одинокие сердца клуб Хэндаль", 7, "Романтическая комедия", "Южная Корея", false));
        m.add(2, new Movie("Паразиты", 9, "Триллер", "Южная Корея", true));
        companies.add(new Company("CJ Entertainment", 1995, m));

        m.set(0, new Movie("Тиранин", 7, "Историческая драма", "Южная Корея", false));
        m.set(1, new Movie("Гандбол!", 7, "Спортивная драма", "Южная Корея", false));
        m.set(2, new Movie("Секретный дневник девушки по вызову", 7, "Романтическая комедия", "Южная Корея", false));
        companies.add(new Company("Lotte Entertainment", 2003, m));

        m.set(0, new Movie("Остров проклятых", 7, "Шпионский триллер", "Южная Корея", false));
        m.set(1, new Movie("Аватар Ким Чжон Вука", 7, "Боевик", "Южная Корея", false));
        m.set(2, new Movie("Гуемби и черный гуаран", 7, "Фэнтези-боевик", "Южная Корея", false));
        companies.add(new Company("Showbox", 1996, m));

        System.out.println("Не мои фильмы:");
        for (Company с : companies) {
            System.out.println(с.toString());
        }
    }
}
