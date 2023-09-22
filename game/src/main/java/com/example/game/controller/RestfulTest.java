package com.example.game.controller;

import com.example.game.model.Player;
import com.example.game.model.PlayerDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestfulTest {


    public static RestTemplate restTemplate=new RestTemplate ();
    public static String url="http://localhost:8080/api/game/player";

    public static void main (String[] args) {
        sendGetAllPlayer ();
        sendCreatePlayer ( 3,"hj",8 );
        sendGetPlayer ( 2 );
        sendUpdatePlayer ( 2,new PlayerDto (4,8,"j") );
        sendGetPlayer ( 2 );
        sendDeletePlayer ( 2 );
        sendGetAllPlayer ();
    }

    public static void sendGetPlayer(int i){
        ResponseEntity<PlayerDto> response=restTemplate.getForEntity ( url+"/"+i,PlayerDto.class );
        PlayerDto playerDto=response.getBody ();
        System.out.println (playerDto);
    }
    public static void sendGetAllPlayer(){
        ResponseEntity<List> response=restTemplate.getForEntity ( url, List.class );
        List<PlayerDto> players=(List<PlayerDto>)response.getBody ();
       if(players!=null)
        System.out.println (players);
    }

    public static void sendCreatePlayer(int id,String name,int score){
        HttpEntity<PlayerDto> httpEntity=new HttpEntity<> ( new PlayerDto (id,score,name) );
        ResponseEntity<PlayerDto> response=restTemplate.postForEntity ( url+"/create",httpEntity,PlayerDto.class);
        System.out.println (response.getBody ());
    }

    public static void sendUpdatePlayer(int id,PlayerDto playerDto){
        HttpEntity<PlayerDto> httpEntity=new HttpEntity<> ( playerDto );
        ResponseEntity<PlayerDto> response=restTemplate.exchange ( url+"/"+id+"/update", HttpMethod.PUT,httpEntity,PlayerDto.class);
        System.out.println (response.getBody ());
    }
    public static void sendDeletePlayer(int id){
        restTemplate.delete ( url+"/"+id+"/delete" );
    }


}
