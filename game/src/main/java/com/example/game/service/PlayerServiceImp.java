package com.example.game.service;

import com.example.game.model.Player;
import com.example.game.model.PlayerDto;
import com.example.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImp implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImp(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }

    @Override
    public List<PlayerDto> getAll () {
        List<Player> players=playerRepository.findAll ();
        return players.stream().map(Player::toPlayerDto).collect( Collectors.toList());
    }

    @Override
    public PlayerDto getPlayerById (int id) {
       return playerRepository.findById ( id ).get ().toPlayerDto ();
    }

    @Override
    public PlayerDto createPlayer (PlayerDto playerDto) {
        Player player=playerDto.toPlayer ();
        return playerRepository.save ( player ).toPlayerDto ();
    }

    @Override
    public PlayerDto updatePlayer (int id , PlayerDto playerDto) {
        Player player=playerRepository.findById ( id ).get ();
        player.setName ( playerDto.getName () );
        player.setScore ( playerDto.getScore () );

        return playerRepository.save ( player ).toPlayerDto ();
    }

    @Override
    public void deletePlayerById (int id) {
        playerRepository.delete ( playerRepository.findById ( id ).get () );
    }
}
