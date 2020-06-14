package com.example.goalalarm;

public class TeamModel {

    private String teamName;
    private String homeLeague;
    private String logo;


    //Default Constructor
    public TeamModel() {

    }

    //Parametrized Constructor
    public TeamModel(String teamName, String homeLeague, String logo) {
        this.teamName = teamName;
        this.homeLeague = homeLeague;
        this.logo = logo;
    }

    //Getters


    public String getTeamName() {
        return teamName;
    }

    public String getHomeLeague() {
        return homeLeague;
    }

    public String getLogo() {
        return logo;
    }
}
