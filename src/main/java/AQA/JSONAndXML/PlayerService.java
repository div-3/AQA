package AQA.JSONAndXML;

import java.util.Collection;

public interface PlayerService {
    // получить игрока по id
    Player getPlayerById(int id);

    // получить список игроков
    Collection<Player> getPlayers();

    //вернуть сохранённые данные из файла
    Collection<Player> getSavedData();

    // создать игрока (возвращает id нового игрока)
    int createPlayer(Player player);

    // удалить игрока по id'шнику, вернет удаленного игрока
    Player deletePlayer(int id);

    // добавить очков игроку. Возвращает обновленный счет
    int addPoints(int playerId, int points);
}
