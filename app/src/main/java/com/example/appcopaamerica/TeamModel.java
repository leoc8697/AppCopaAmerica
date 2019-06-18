package com.example.appcopaamerica;

public class TeamModel {

    private String flagTeam, nameTeam;

    public TeamModel(String flagTeam, String nameTeam) {
        this.flagTeam = flagTeam;
        this.nameTeam = nameTeam;
    }

    public String getFlagTeam() {
        return flagTeam;
    }

    public void setFlagTeam(String flagTeam) {
        this.flagTeam = flagTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}
