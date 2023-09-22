package com.example.game.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int score;
    public Player(int id,int score,String name){
        this.id=id;
        this.name=name;
        this.score=score;
    }

    public Player(){

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
    public PlayerDto toPlayerDto(){
        return new PlayerDto (this.id,this.score,this.name);
    }
}
