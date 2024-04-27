package com.gamblinggenie.PassionProjectGamblingGenie.Models;
import jakarta.persistence.*;

@Entity
public class MLBGameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int gamePk;

    private String gameGuid;

    private String link;

    private String gameType;

    private String season;

    private String gameDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getGamePk() {
        return gamePk;
    }

    public void setGamePk(int gamePk) {
        this.gamePk = gamePk;
    }

    public String getGameGuid() {
        return gameGuid;
    }

    public void setGameGuid(String gameGuid) {
        this.gameGuid = gameGuid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }
}
