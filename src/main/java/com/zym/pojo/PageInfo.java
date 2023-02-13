package com.zym.pojo;

import java.util.List;

public class PageInfo<T> {

    private int pageCount=0;    //总页数

    private int pageSize=3;    //每页显示记录数

    private int totalCount;    //总记录条数

    private int currPage=1;   //当前页码

    private List<T> arrList;     //每页的对象实体集合

    private int begin=0;          //从第几条开始显示

    private String msgName;

    private Integer type_Id;

    public PageInfo(){}

    public PageInfo(int pageCount, int pageSize, int totalCount, int currPage,
                    List arrList) {
        super();
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.currPage = currPage;
        this.arrList = arrList;
    }

    public int getPageCount() {       //计算总页数
        if(getTotalCount()%getPageSize()==0){
            pageCount=getTotalCount()/getPageSize();
        }else{
            pageCount=getTotalCount()/getPageSize()+1;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        if(currPage<=1){
            currPage=1;
        }
        this.currPage = currPage;
    }

    public List<T> getArrList() {
        return arrList;
    }

    public void setArrList(List<T> arrList) {
        this.arrList = arrList;
    }

    public int getBegin() {
        return begin=(getCurrPage()-1)*getPageSize();
    }

    public void setBegin(int begin) {
        begin=(getCurrPage()-1)*getPageSize();
        this.begin = begin;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        if(msgName!=null && !msgName.equals("")) {
            System.out.println("开始的msgName"+msgName);
            int index = msgName.lastIndexOf(",");
            if(index!=-1) {
                msgName = msgName.substring(0, index);
                System.out.println("截取后的msgName"+msgName);
            }
        }
        this.msgName = msgName;
    }

    public Integer getType_Id() {
        return type_Id;
    }

    public void setType_Id(Integer type_Id) {
        this.type_Id = type_Id;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", currPage=" + currPage +
                ", arrList=" + arrList +
                ", begin=" + begin +
                ", msgName='" + msgName + '\'' +
                ", type_Id=" + type_Id +
                '}';
    }
}
