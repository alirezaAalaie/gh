package com.example.game.controller;


import com.example.game.model.Player;
import com.example.game.model.PlayerDto;
import com.example.game.service.PlayerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/game/player")
public class RestController {

    private final PlayerServiceImp playerServiceImp;

    @Autowired
    public RestController (PlayerServiceImp playerServiceImp) {
        this.playerServiceImp = playerServiceImp;
    }

    @GetMapping("")
    public ResponseEntity<List<PlayerDto>> getAll(){
        return ResponseEntity.ok (playerServiceImp.getAll ());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable int id) {
        return ResponseEntity.ok(playerServiceImp.getPlayerById ( id ));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        return ResponseEntity.ok(playerServiceImp.createPlayer ( playerDto ));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<PlayerDto> updatePlayer(@RequestBody PlayerDto playerDto, @PathVariable("id") int currentId) {
        return ResponseEntity.ok(playerServiceImp.updatePlayer ( currentId,playerDto ));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        playerServiceImp.deletePlayerById ( id );
        return ResponseEntity.ok("Deleted");
    }
}





