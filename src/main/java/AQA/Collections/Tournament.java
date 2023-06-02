package AQA.Collections;

import java.util.*;

public class Tournament {

    private Map<Player, Integer> map;

    public Tournament() {
        map = new HashMap<>();
    }

    public boolean addPlayer(Player player) {
        return (this.map.put(player, 0)) == null;
    }

    //Функция установки очков определённому пользователю
    public void setPoints(int id, int points) {
        for (Player p : this.map.keySet()) {
            if (p.getId() == id) this.map.replace(p, points);
        }
    }

    //Вывод на экран ТОП-Х игроков
    public void showTopX(int x) {
        List<Player> top3List = new ArrayList<>();
        if (x > map.size()) x = map.size();

        for (int i = 0; i < x; i++) {
            top3List.add(i, map.keySet().stream().toList().get(0));
            Integer max = 0;
            for (Player p : map.keySet()) {
                if (!top3List.contains(p) && max <= map.get(p)) {
                    max = map.get(p);
                    top3List.set(i, p);
                }
            }
            System.out.println((i + 1) + ". " + top3List.get(i).toString() + "  " + max);
        }
    }

    //Вывод на экран ТОП-Х игроков
    public void getTopX(int x) {
//        List<Player> top3List = new ArrayList<>();
        List<Map.Entry<Player, Integer>> top3List = new ArrayList<>();
        if (x > map.size()) x = map.size();

        for (int i = 0; i < x; i++) {
            top3List.add(i, map.entrySet().stream().toList().get(0));
            Integer max = 0;
            for (Player p : map.keySet()) {
                if (!top3List.contains(p) && max <= map.get(p)) {
                    max = map.get(p);
//                    top3List.set(i, map.entrySet().stream().toList(). );
                }
            }
            System.out.println((i + 1) + ". " + top3List.get(i).toString() + "  " + max);
        }
    }
}
