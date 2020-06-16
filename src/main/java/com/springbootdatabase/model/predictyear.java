package com.springbootdatabase.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class predictyear {

    private String m2020예측;
    private String m2019예측;
    private String 상권_코드_명;

    public String getM2020예측() {
        return m2020예측;
    }

    public void setM2020예측(String m2020예측) {
        this.m2020예측 = m2020예측;
    }

    public String getM2019예측() {
        return m2019예측;
    }

    public void setM2019예측(String m2019예측) {
        this.m2019예측 = m2019예측;
    }

    public String get상권_코드_명() {
        return 상권_코드_명;
    }

    public void set상권_코드_명(String 상권_코드_명) {
        this.상권_코드_명 = 상권_코드_명;
    }
}