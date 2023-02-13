package com.zym.pojo;

public class TestAjax {
    private int currPage;
    private String statusN;
    private String oIdN;

    public TestAjax() {
    }

    public TestAjax(int currPage, String statusN, String oIdN) {
        this.currPage = currPage;
        this.statusN = statusN;
        this.oIdN = oIdN;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public String getStatusN() {
        return statusN;
    }

    public void setStatusN(String statusN) {
        this.statusN = statusN;
    }

    public String getoIdN() {
        return oIdN;
    }

    public void setoIdN(String oIdN) {
        this.oIdN = oIdN;
    }

    @Override
    public String toString() {
        return "TestAjax{" +
                "currPage=" + currPage +
                ", statusN='" + statusN + '\'' +
                ", oIdN='" + oIdN + '\'' +
                '}';
    }
}
