package AQA.JSONAndXML;

/*1. Сервис игроков (JSON)
Создайте класс Player. Скопируйте ссылка
Создайте класс PlayerServiceJSON. Класс должен имплементировать методы интерфейса PlayerService (ссылка)
[https://github.com/EreminD/aqa-course/blob/main/src/main/java/ru/inno/course/serializer/hw/PlayerService.java]
Программа должна сохранять свое состояние в файл формата JSON
Все изменения коллекции сохраняются в файл (файл перезаписывается)
Создайте класс TestClass. В нем метод psvm
В методе создайте экземпляр класс
PlayerService service = new PlayerServiceJSON();
Протестируйте методы сервиса. Убедитесь, что все изменения сохраняются (или удаляются) в файле*/

import java.util.Random;

public class TestClass {
    public static void main(String[] args) {
        PlayerService service = new PlayerServiceJSON();

        for (int i = 0; i < 10; i++) {
            service.createPlayer(
                    new Player(i, ("Player" + (i + 1)), new Random().nextInt(1, 10), (i % 2 == 0)));
        }

        //Изначальная сколлекция игроков
        System.out.println("---------------------------------------------------------------");
        System.out.println("Изначальная сколлекция игроков");
        for (Player p : service.getPlayers()) {
            System.out.println(p.toString());
        }

        service.addPoints(1, 10);
        service.addPoints(2, 10);
        service.addPoints(5, 10);
        service.addPoints(7, 10);
        service.addPoints(9, 10);

        //Коллекция игроков после изменения очков
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков после изменения очков");
        for (Player p : service.getPlayers()) {
            System.out.println(p.toString());
        }

        service.deletePlayer(0);
        service.deletePlayer(2);
        service.deletePlayer(4);
        service.deletePlayer(6);
        service.deletePlayer(8);
        service.deletePlayer(10);

        //Коллекция игроков после удаления
        System.out.println("---------------------------------------------------------------");
        System.out.println("Коллекция игроков после удаления");
        for (Player p : service.getPlayers()) {
            System.out.println(p.toString());
        }

    }
}
