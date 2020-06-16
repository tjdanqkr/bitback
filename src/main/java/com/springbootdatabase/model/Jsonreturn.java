package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jsonreturn {

    private String gil;
    private int totalscore;

    public String getGil() {
        return this.gil;
    }

    public void setGil(String gil) {
        this.gil = gil;
    }

    public int getTotalscore() {
        return this.totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

}
