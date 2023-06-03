package AQA.JSONAndXML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class PlayerServiceXML implements PlayerService {
    private Collection<Player> players = new ArrayList<>();
    private Path path = Path.of("./players.xml");
    XmlMapper mapper = new XmlMapper();

    @Override
    public Collection<Player> getSavedData() {
        if (!Files.exists(this.path)) return null;
        try {
            return mapper.readValue(path.toFile(), new TypeReference<>(){});   //Чтение МАССИВА игроков
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveData() {
        try {
            String xmlString = mapper.writeValueAsString(this.players);
            Files.deleteIfExists(path);
            Files.writeString(path, xmlString);
            System.out.println("Данные сохранены в XML");
            return true;
        } catch (IOException e) {
            System.out.println("Проблема с сохранением файла: " + e.toString());
        }
        return false;
    }

    @Override
    public Player getPlayerById(int id) {
        for (Player p : players) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public int createPlayer(Player player) {
        players.add(player);
        saveData();
        return player.getId();
    }

    @Override
    public Player deletePlayer(int id) {
        Player p = getPlayerById(id);
        if (p == null) return null;
        players.remove(p);
        saveData();
        return p;
    }

    @Override
    public int addPoints(int playerId, int points) {
        Player p = getPlayerById(playerId);
        if (p == null) return 0;
        int currentPoints = p.getPoints() + points;
        p.setPoints(currentPoints);
        saveData();
        return currentPoints;
    }
}