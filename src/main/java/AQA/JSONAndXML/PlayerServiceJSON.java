package AQA.JSONAndXML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlayerServiceJSON implements PlayerService {
    private Collection<Player> players = new ArrayList<>();

    @JsonIgnore
    private Path path = Path.of("./players.json");
    @JsonIgnore
    ObjectMapper objectMapper = new ObjectMapper();

    public PlayerServiceJSON() {
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public void restoreData() {
        if (Files.exists(this.path)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                players = objectMapper.readValue(path.toFile(), PlayerServiceJSON.class).players;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean saveData() {
        try {
            String json = objectMapper.writeValueAsString(this);
            Files.deleteIfExists(path);
            Files.writeString(path, json);
        } catch (IOException e) {
            System.out.println("Проблема с сохранением файла: " + e.toString());
        }
        return false;
    }

    @Override
    public Player getPlayerById(int id) {
        if (id > players.size() - 1) return null;
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
