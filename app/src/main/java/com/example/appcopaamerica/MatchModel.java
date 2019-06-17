package com.example.appcopaamerica;

public class MatchModel{
    private String team1, team2, score, dateMatch;
    //private int flagTeam1, flagTeam2;

    public MatchModel(String team1, String team2, String score, String dateMatch){ //int flagTeam1, int flagTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.dateMatch = dateMatch;
        //this.flagTeam1 = flagTeam1;
        //this.flagTeam2 = flagTeam2;
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
/*
    public int getFlagTeam1() {
        return flagTeam1;
    }

    public void setFlagTeam1(int flagTeam1) {
        this.flagTeam1 = flagTeam1;
    }

    public int getFlagTeam2() {
        return flagTeam2;
    }

    public void setFlagTeam2(int flagTeam2) {
        this.flagTeam2 = flagTeam2;
    }
    */
}
