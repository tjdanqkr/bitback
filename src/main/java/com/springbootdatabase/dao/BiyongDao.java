package com.springbootdatabase.dao;

import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.hap;

public interface BiyongDao {
    hap happrintbiyong(Biyong biyong);

    

    void setBiyong(Biyong biyong);
    void deleteBiyong(Biyong biyong);
}
