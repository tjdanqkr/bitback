package com.springbootdatabase.model;


public class CucheonDto {

    private String gil;
    private String avg평균매출;
    private String coffee평균매출;

    public String getAvg평균매출() {
        return avg평균매출;
    }

    public void setAvg평균매출(String avg평균매출) {
        this.avg평균매출 = avg평균매출;
    }

    public String getCoffee평균매출() {
        return coffee평균매출;
    }

    public void setCoffee평균매출(String coffee평균매출) {
        this.coffee평균매출 = coffee평균매출;
    }

    public String getGil() {
        return gil;
    }

    public void setGil(String gil) {
        this.gil = gil;
    }


}