package com.example.game.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PlayerDto implements Serializable {
    private String name;
    private int id;
    private int score;
    public PlayerDto(int id,int score,String name){
        this.id=id;
        this.name=name;
        this.score=score;
    }

    public PlayerDto(){

    }
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getScore () {
        return score;
    }

    public void setScore (int score) {
        this.score = score;
    }
    public Player toPlayer() {
        return new Player ( this.id , this.score , this.name );
    }

    @Override
    public String toString () {
        return "PlayerDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}
