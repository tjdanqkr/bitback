package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChuiDto {
    private String 기준_분기_코드;
    private String 상권_코드_명;
    private String 분기별_매출;
    private String 기준_년_코드;

    public String get기준_분기_코드() {
        return this.기준_분기_코드;
    }

    public void set기준_분기_코드(String 기준_분기_코드) {
        this.기준_분기_코드 = 기준_분기_코드;
    }

    public String get상권_코드_명() {
        return this.상권_코드_명;
    }

    public void set상권_코드_명(String 상권_코드_명) {
        this.상권_코드_명 = 상권_코드_명;
    }

    public String get분기별_매출() {
        return this.분기별_매출;
    }

    public void set분기별_매출(String 분기별_매출) {
        this.분기별_매출 = 분기별_매출;
    }

    public String get기준_년_코드() {
        return this.기준_년_코드;
    }

    public void set기준_년_코드(String 기준_년_코드) {
        this.기준_년_코드 = 기준_년_코드;
    }
    

}