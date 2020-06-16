package com.springbootdatabase.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Upjong {

    private double x;
    private double y;
    private String gu;
    private String dong;
    private String address;
    private String names;
    private String classes;

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getGu() {
        return this.gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDong() {
        return this.dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

}
