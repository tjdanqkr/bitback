package com.springbootdatabase.service;

import com.springbootdatabase.model.Biyong;

import java.beans.BeanInfo;

public interface BiyongService {
    Biyong printbiyong(Biyong biyong);
    void insertbiyong(Biyong biyong);
    void deletebiyong(Biyong biyong);
}
