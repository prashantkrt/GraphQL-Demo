package com.mylearning.grapghqldemo.service;

import com.mylearning.grapghqldemo.model.Player;
import com.mylearning.grapghqldemo.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {

    private final List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0);

    public Player createPlayer(String name, Team team) {
        Player newPlayer = new Player(id.incrementAndGet(), name, team);
        players.add(newPlayer);
        return newPlayer;
    }

    public Player addPlayer(Player player) {
        players.add(player);
        return player;
    }

    public List<Player> findAll() {
        return players;
    }

    public Player findById(int id) {
        return players.stream().filter(player -> player.id() == id).findFirst().orElse(null);
    }

    public Player deleteById(int id) {
        Player player = findById(id);
        players.remove(player);
        return player;
    }

    public Player updatePlayer(Integer id, String name, Team team) {
        Player player = findById(id);
        int index = players.indexOf(player);
        players.set(index, new Player(id, name, team));
        return players.get(index);
    }

    @PostConstruct
    private void init() {
        players.add(new Player(id.incrementAndGet(), "Dhoni", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Rohit", Team.RCB));
        players.add(new Player(id.incrementAndGet(), "Virat", Team.RCB));
        players.add(new Player(id.incrementAndGet(), "Kohli", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Yuvraj", Team.RCB));
        players.add(new Player(id.incrementAndGet(), "Pandey", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Jadeja", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Bumrah", Team.RCB));
        players.add(new Player(id.incrementAndGet(), "Shami", Team.RCB));
    }
}
