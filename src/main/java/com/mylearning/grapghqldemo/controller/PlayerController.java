package com.mylearning.grapghqldemo.controller;

import com.mylearning.grapghqldemo.model.Player;
import com.mylearning.grapghqldemo.model.Team;
import com.mylearning.grapghqldemo.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @MutationMapping
    public Player addPlayer(@Argument("name") String name, @Argument("team") Team team) {
        return playerService.createPlayer(name, team);
    }

    @QueryMapping
    public List<Player> findAllPlayers() {
        return playerService.findAll();
    }

    @QueryMapping
    public Player findPlayerById(@Argument("id") int id) {
        return playerService.findById(id);
    }

    @MutationMapping
    public Player updatePlayer(@Argument("id") int id, @Argument("name") String name, @Argument("team") Team team) {
        return playerService.updatePlayer(id, name, team);
    }

    @MutationMapping
    public Player deletePlayer(@Argument("id") int id) {
        return playerService.deleteById(id);
    }
}
