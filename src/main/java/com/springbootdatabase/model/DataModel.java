package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataModel {

    private String dong;

    public String getDong() {
        return this.dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

}
