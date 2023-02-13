package com.zym.pojo;

public class Users {
    private Integer uId;
    private String uName;
    private String uPass;
    private Integer uStatus;    //会员状态
    private Integer uLevel;    //用户等级
    private Integer score;     //用户积分

    public Users(Integer uId, String uName, String uPass, Integer uStatus, Integer uLevel, Integer score) {
        this.uId = uId;
        this.uName = uName;
        this.uPass = uPass;
        this.uStatus = uStatus;
        this.uLevel = uLevel;
        this.score = score;
    }

    public Users() {
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public Integer getuLevel() {
        return uLevel;
    }

    public void setuLevel(Integer uLevel) {
        this.uLevel = uLevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPass='" + uPass + '\'' +
                ", uStatus=" + uStatus +
                ", uLevel=" + uLevel +
                ", score=" + score +
                '}';
    }
}
