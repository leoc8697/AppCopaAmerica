package com.example.appcopaamerica;

import android.graphics.ColorMatrix;

public class MatchModel{
    private String team1, team2, score, dateMatch, flagTeam1, flagTeam2;

    public MatchModel(String team1, String team2, String score, String dateMatch, String flagTeam1, String flagTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.dateMatch = dateMatch;
        this.flagTeam1 = flagTeam1;
        this.flagTeam2 = flagTeam2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getFlagTeam1() {
        return flagTeam1;
    }

    public void setFlagTeam1(String flagTeam1) {
        this.flagTeam1 = flagTeam1;
    }

    public String getFlagTeam2() {
        return flagTeam2;
    }

    public void setFlagTeam2(String flagTeam2) {
        this.flagTeam2 = flagTeam2;
    }

}
