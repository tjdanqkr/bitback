package com.springbootdatabase.dao;

import com.springbootdatabase.model.Biyong;

public interface BiyongDao {
    Biyong printbiyong(Biyong biyong);

    

    void setBiyong(Biyong biyong);
    void deleteBiyong(Biyong biyong);
}
