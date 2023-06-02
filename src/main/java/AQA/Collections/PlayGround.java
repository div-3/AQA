package AQA.Collections;

public class PlayGround {
    public static void main(String[] args) {

        //Создание турнира
        Tournament tournament = new Tournament();

        //Добавление игроков
        tournament.addPlayer(new Player(1, "N0tail", true));
        tournament.addPlayer(new Player(2, "Ceb", true));
        tournament.addPlayer(new Player(3, "ana", true));
        tournament.addPlayer(new Player(4, "Topson", true));
        tournament.addPlayer(new Player(5, "s4", true));
        tournament.addPlayer(new Player(6, "Lil", true));
        tournament.addPlayer(new Player(7, "Misha", true));
        tournament.addPlayer(new Player(8, "No[o]ne", true));
        tournament.addPlayer(new Player(9, "MoonMeander", true));
        tournament.addPlayer(new Player(10, "QO", true));

        //Проверка уникальности игроков путём добавления дубликата
        System.out.println(
                (tournament.addPlayer(new Player(10, "QO", true)))
                        ? "Игрок добавился второй раз. Не должно так быть!"
                        : "Игрок второй раз не добавился.");     //Игрок не должен добавиться

        //Установка очков ирокам
        tournament.setPoints(4, 10);
        tournament.setPoints(7, 12);
        tournament.setPoints(8, 11);
        tournament.setPoints(9, 13);
        tournament.setPoints(10, 5);

        //Вывод ТОП-X игроков
        System.out.println("-----------------------------");
        System.out.println("ТОП-3:");
        tournament.showTopX(3);
        System.out.println("-----------------------------");
        System.out.println("ТОП-6:");
        tournament.showTopX(6);
        System.out.println("-----------------------------");
        System.out.println("ТОП-14 -> ТОП-10:");
        tournament.showTopX(14);
    }
}
