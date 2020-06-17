package com.springbootdatabase.service.Impl;

import com.springbootdatabase.dao.BiyongDao;
import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.hap;
import com.springbootdatabase.service.BiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootdatabase.model.hap;
@Service
public class BiyongServiceImpl implements BiyongService {

    @Autowired
    BiyongDao biyongDao;

    @Override
    public hap happrintbiyong(final Biyong biyong) {
        final hap biyong1 = biyongDao.happrintbiyong(biyong);
        System.out.println(biyong1);
        return biyong1;
    }

    @Override
    public void insertbiyong(final Biyong biyong) {
        biyongDao.setBiyong(biyong);
    }

    @Override
    public void deletebiyong(final Biyong biyong) {
        biyongDao.deleteBiyong(biyong);
    }

    @Override
    public Biyong printbiyong(final Biyong biyong) {
        // TODO Auto-generated method stub
        return null;
    }
}
