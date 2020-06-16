package com.springbootdatabase.service;

import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.hap;

import java.beans.BeanInfo;

public interface BiyongService {
    hap happrintbiyong(Biyong biyong);
    Biyong printbiyong(Biyong biyong);
    void insertbiyong(Biyong biyong);
    void deletebiyong(Biyong biyong);
}
