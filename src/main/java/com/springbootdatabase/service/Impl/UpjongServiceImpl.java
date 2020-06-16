package com.springbootdatabase.service.Impl;

import com.springbootdatabase.dao.UpjongDao;
import com.springbootdatabase.model.Jsonreturn;
import com.springbootdatabase.model.Upjong;
import com.springbootdatabase.service.UpjongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UpjongServiceImpl implements UpjongService {

    @Autowired
    UpjongDao upjongDao;

    @Override
    public HashMap<String, List<Upjong>> printUpjong(Upjong upjong){

        List<Upjong> upjongs = upjongDao.printUpjong(upjong);

        HashMap<String,List<Upjong>> upjong1= new HashMap<>();
        upjong1.put("업종",upjongs);

        return upjong1;
    }
}
