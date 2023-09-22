package com.example.game.service;

import com.example.game.model.PlayerDto;

import java.util.List;

public interface PlayerService {
     List<PlayerDto> getAll();
    PlayerDto getPlayerById (int id);
    PlayerDto createPlayer(PlayerDto playerDto);

    PlayerDto updatePlayer(int id,PlayerDto playerDto);
    void deletePlayerById(int id);

}
