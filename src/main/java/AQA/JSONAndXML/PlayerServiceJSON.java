package AQA.JSONAndXML;

import java.util.ArrayList;
import java.util.Collection;
import com.fasterxml.jackson.core.*;

public class PlayerServiceJSON implements PlayerService{
    private Collection<Player> players = new ArrayList<>();

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
        return player.getId();
    }

    @Override
    public Player deletePlayer(int id) {
        Player p;
        if ((p = getPlayerById(id)) == null) return null;
        players.remove(p);
        return p;
    }

    @Override
    public int addPoints(int playerId, int points) {
        Player p = getPlayerById(playerId);
        if (p == null) return 0;
        int currentPoints = p.getPoints() + points;
        p.setPoints(currentPoints);
        return currentPoints;
    }
}
