package com.example.temp;


import java.util.Date;

public class TeamData {
    String teamID, teamHead, playertwoName, playerthreeName, playerfourName, courtName, courtID, memberNo, date, time;

    public TeamData() {
    }

    public TeamData(String teamID, String teamHead, String membersNo, String playertwoName, String playerthreeName, String playerfourName, String courtName, String courtID, String t, String date) {

        this.teamID = teamID;
        this.teamHead = teamHead;
        this.playertwoName = playertwoName;
        this.playerthreeName = playerthreeName;
        this.playerfourName = playerfourName;
        this.courtName = courtName;
        this.memberNo = membersNo;
        this.courtID = courtID;
        this.date = date;
        this.time = time;

    }

    public TeamData(String teamName, String teamHead, String membersNo, String playertwo, String playerThree, String playerFour, String courtName) {
        this.teamID = teamName;
        this.teamHead = teamHead;
        this.playertwoName = playertwo;
        this.playerthreeName = playerThree;
        this.playerfourName = playerFour;
        this.courtName = courtName;
        this.memberNo = membersNo;
        this.date = "02/12/20";
        this.time = "105700";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getCourtID() {
        return courtID;
    }

    public void setCourtID(String courtID) {
        this.courtID = courtID;
    }

    public String getTeamHead() {
        return teamHead;
    }

    public void setTeamHead(String teamHead) {
        this.teamHead = teamHead;
    }

    public String getPlayertwoName() {
        return playertwoName;
    }

    public void setPlayertwoName(String playertwoName) {
        this.playertwoName = playertwoName;
    }

    public String getPlayerthreeName() {
        return playerthreeName;
    }

    public void setPlayerthreeName(String playerthreeName) {
        this.playerthreeName = playerthreeName;
    }

    public String getPlayerfourName() {
        return playerfourName;
    }

    public void setPlayerfourName(String playerfourName) {
        this.playerfourName = playerfourName;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
}
