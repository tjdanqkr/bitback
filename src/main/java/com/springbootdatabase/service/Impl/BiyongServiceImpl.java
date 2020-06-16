package com.springbootdatabase.service.Impl;

import com.springbootdatabase.dao.BiyongDao;
import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.service.BiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiyongServiceImpl implements BiyongService {

    @Autowired
    BiyongDao biyongDao;

    @Override
    public Biyong printbiyong(Biyong biyong)
    {
        Biyong biyong1 = biyongDao.printbiyong(biyong);
        return biyong1;
    }
    @Override
    public void insertbiyong(Biyong biyong)
    {
        biyongDao.setBiyong(biyong);
    }
    @Override
    public void deletebiyong(Biyong biyong)
    {
        biyongDao.deleteBiyong(biyong);
    }
}
