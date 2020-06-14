package com.example.goalalarm;

public class MatchesModel {

    private String date;
    private String time;
    private String league;
    private String homeTeamLogo;
    private String awayTeamLogo;
    private String homeTeamName;
    private String awayTeamName;



    //Default Constructor
    public MatchesModel() {
    }

    //Parametrized Constructor
    public MatchesModel(String date, String time, String league, String homeTeamLogo,
                        String awayTeamLogo, String homeTeamName, String awayTeamName) {
        this.date = date;
        this.time = time;
        this.league = league;
        this.homeTeamLogo = homeTeamLogo;
        this.awayTeamLogo = awayTeamLogo;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
    }

    //Getters


    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLeague() {
        return league;
    }

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }

    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }
}
