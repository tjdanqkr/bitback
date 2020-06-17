package com.springbootdatabase.controller;

import com.springbootdatabase.model.CucheonDto;
import com.springbootdatabase.model.Upjong;
import com.springbootdatabase.service.UpjongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

@RestController
public class upjongController {

    @Autowired
    private UpjongService upjongService;
    
//    @ResponseBody//select
//    @RequestMapping(value="/upjong2",method= RequestMethod.POST)
//    public HashMap<String, List<Upjong>> upjong(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
//    {
//        request.setCharacterEncoding("utf-8");
//        Upjong upjong1 = new Upjong();
//        upjong1.setClasses(post.get("classes").toString());
//
//        HashMap<String,List<Upjong>> upjong2 = upjongService.printUpjong(upjong1);
//        return upjong2;
//    }
    
    @ResponseBody
    @RequestMapping(value ="/api/upjong", method = RequestMethod.POST)
    public ResponseEntity<Upjong[]> upjong(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("UTF-8");
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String,String> map = new HashMap<>();
        String url = "http://localhost:5000/upjong";
        map.put("classes",post.get("classes").toString());
        System.out.println(post.get("classes").toString());
        HttpEntity<?> entity = new HttpEntity<>(map);

        ResponseEntity<Upjong[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Upjong[].class);
        System.out.println(responseEntity.getBody());

       // HashMap<String,ResponseEntity> map1 = new HashMap<>();
        //  map1.put("postions",responseEntity);
//      System.out.println(map1.get("postions").getBody());
        return responseEntity;
    }
}
