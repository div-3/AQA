package AQA.JSONAndXML;
//https://habr.com/ru/companies/otus/articles/687004/

/*1. Сервис игроков (JSON)
Создайте класс Player. Скопируйте ссылка
Создайте класс PlayerServiceJSON. Класс должен имплементировать методы интерфейса PlayerService (ссылка)
[https://github.com/EreminD/aqa-course/blob/main/src/main/java/ru/inno/course/serializer/hw/PlayerService.java]
Программа должна сохранять свое состояние в файл формата JSON
Все изменения коллекции сохраняются в файл (файл перезаписывается)
Создайте класс TestClass. В нем метод psvm
В методе создайте экземпляр класс
PlayerService service = new PlayerServiceJSON();
Протестируйте методы сервиса. Убедитесь, что все изменения сохраняются (или удаляются) в файле

2. СО ЗВЕЗДОЧКОЙ. Сервис игроков (XML)
Все то же самое, только создайте класс PlayerServiceXML.
"Черный ящик" (логика) вся та же
PlayerService service = new PlayerServiceXML();*/

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        PlayerService serviceJson = new PlayerServiceJSON();
        PlayerService serviceXml = new PlayerServiceXML();

        System.out.println("Создание коллекции:");
        for (int i = 0; i < 5; i++) {
            serviceJson.createPlayer(
                    new Player(i, ("Player" + (i + 1)), new Random().nextInt(1, 10), (i % 2 == 0)));
            serviceXml.createPlayer(
                    new Player(i, ("Player" + (i + 1)), new Random().nextInt(1, 10), (i % 2 == 0)));
        }

        //Начальная коллекция игроков
        System.out.println("---------------------------------------------------------------");
        System.out.println("Начальная коллекция игроков (JSON):");
        for (Player p : serviceJson.getPlayers()) {
            System.out.println(p.toString());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Начальная коллекция игроков (XML):");
        for (Player p : serviceXml.getPlayers()) {
            System.out.println(p.toString());
        }

        //Добавление очков игрокам JSON
        System.out.println("Добавление очков игрокам JSON");
        serviceJson.addPoints(1, 10);
        serviceJson.addPoints(2, 10);
        serviceJson.addPoints(5, 10);

        //Добавление очков игрокам XML
        System.out.println("Добавление очков игрокам XML");
        serviceXml.addPoints(1, 10);
        serviceXml.addPoints(2, 10);
        serviceXml.addPoints(5, 10);

        //Коллекция игроков после изменения очков (JSON)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков после изменения очков (JSON)");
        for (Player p : serviceJson.getPlayers()) {
            System.out.println(p.toString());
        }

        //Коллекция игроков после изменения очков (XML)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков после изменения очков (XML)");
        for (Player p : serviceXml.getPlayers()) {
            System.out.println(p.toString());
        }

        //Удаление игроков по id (JSON)
        System.out.println("Удаление игроков по id (JSON)");
        serviceJson.deletePlayer(0);
        serviceJson.deletePlayer(2);
        serviceJson.deletePlayer(4);

        //Удаление игроков по id (XML)
        System.out.println("Удаление игроков по id (XML)");
        serviceXml.deletePlayer(0);
        serviceXml.deletePlayer(2);
        serviceXml.deletePlayer(4);

        //Коллекция игроков после удаления (JSON)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков после удаления (JSON)");
        for (Player p : serviceJson.getPlayers()) {
            System.out.println(p.toString());
        }

        //Коллекция игроков после удаления(XML)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков после удаления (XML)");
        for (Player p : serviceXml.getPlayers()) {
            System.out.println(p.toString());
        }

        //Коллекция игроков из файла (JSON)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков из файла (JSON)");
        for (Player p : serviceJson.getSavedData()) {
            System.out.println(p.toString());
        }

        //Коллекция игроков из файла (XML)
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков из файла (XML)");
        for (Player p : serviceXml.getSavedData()) {
            System.out.println(p.toString());
        }
    }
}