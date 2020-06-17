package com.springbootdatabase.controller;

import com.springbootdatabase.model.ChuiDto;
import com.springbootdatabase.model.DataModel;
import com.springbootdatabase.model.Jsonreturn;
import com.springbootdatabase.model.Upjong;
import com.springbootdatabase.model.instarDto;
import com.springbootdatabase.model.instarDto2;
import com.springbootdatabase.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class graphController {

    @Autowired
    private DataService dataService;

    @ResponseBody
    @RequestMapping(value="/api/graph",method= RequestMethod.POST)
    public HashMap<String, List<Jsonreturn>> json1(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception {

        request.setCharacterEncoding("UTF-8");
        DataModel dataModel = new DataModel();
        String dong = post.get("dong").toString();
        System.out.println(dong);
        if(dong.equals("잠실동")){
            dong = "잠실본동";
        }
        dataModel.setDong(dong);

        HashMap<String,List<Jsonreturn>> jsonreturn= dataService.findData(dataModel);
        return jsonreturn;
    }

    @ResponseBody
    @RequestMapping(value ="/api/instar", method = RequestMethod.POST)
    public instarDto[] instar(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("UTF-8");
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String,String> map = new HashMap<>();
        String url = "http://localhost:5000/instar";
        map.put("word",post.get("word").toString());//request로 날아오는것에서 원하는 정보 빼줌
        
        String Onedate =post.get("date1").toString(); //2020-06-08
        String twodate =post.get("date2").toString(); //2020-06-11
        System.out.println("Onedate:"+Onedate);

        String month1 = Onedate.substring(0,8);//2020-06-
       // String month2 = twodate.substring(0,8);//2020-06-
        System.out.println("month1:"+month1);

        int date1 = Integer.parseInt(Onedate.substring(8));//08
        int date2 = Integer.parseInt(twodate.substring(8)); //11
        System.out.println("date1:"+date1);
        int j=0;
        StringBuilder _query= new StringBuilder();
        for(int i= date1;i<=date2;++i)
        {
            _query= new StringBuilder();
            if(i<date2)
            {
                if(i<10)
                {
                    _query.append(month1+'0'+i);
                }
                else
                {
                    _query.append(month1+i);
                }
            }
            else if(i==date2)
            {
                if(i<10)
                {
                    _query.append(month1+'0'+i);
                }
                else {
                    _query.append( month1 + i );
                }
            }map.put("date"+j,_query.toString());
            System.out.println(j);
            j++;

        }
        map.put("num", String.valueOf(j));
//        _query.append("2020-06-10");
        System.out.println(_query);


        HttpEntity<?> entity = new HttpEntity<>(map);
        //String responseEntity = restTemplate.getForObject(url, String.class, map);

 //     ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        ResponseEntity<instarDto[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, instarDto[].class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        //날짜의 시작,끝,검색값
        //카운트값
        instarDto[] list = responseEntity.getBody();
        System.out.println(list[0]);
        return list;
    }
    @ResponseBody// 통신 메시지 관련 header와 body의 값들을 하나의 객체로 저장하는 것이 HttpEntity 클래스 객체,Request 부분일 경우 HttpEntity를 상속받은 RequestEntity가, Response 부분일 경우 HttpEntity를 상속받은 ResponseEntity가 하게
    @RequestMapping(value ="/api/chui", method = RequestMethod.POST)// RestTemplate 이용하여 Flask에 접속
    public ChuiDto[] chui(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("UTF-8");
        
        
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String,String> map = new HashMap<>();
        String url = "http://localhost:5000/chuigr";
        //map.put("classes",post.get("classes").toString());//request로 날아오는것에서 원하는 정보 빼줌
        map.put("dong",post.get("dong").toString());
        HttpEntity<?> entity = new HttpEntity<>(map);
        //String responseEntity = restTemplate.getForObject(url, String.class, map);

        ResponseEntity<ChuiDto[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, ChuiDto[].class);
        System.out.println(responseEntity);
        ChuiDto[] json = responseEntity.getBody();
        System.out.println(json[0].get기준_년_코드());
        System.out.println(json[0].get기준_분기_코드());
        System.out.println(json[0].get분기별_매출());
        System.out.println(json[0].get상권_코드_명());
        return json;
    }
    @ResponseBody
    @RequestMapping(value ="/api/instar2", method = RequestMethod.GET) //api/instar2가 키, 기능에 따라 method = RequestMethod.?이 들어가는것.
    public List<String> instar2() throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String,String> map = new HashMap<>();
        String url = "http://localhost:5000/instar2";

        HttpEntity<?> entity = new HttpEntity<>(map);
        ResponseEntity<instarDto2> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, instarDto2.class);
        System.out.println(responseEntity.getBody());

        instarDto2 a=responseEntity.getBody();
        List<String> list = new ArrayList<>();
        for(int i =0; i< a.getDate().length;++i)
        {
            list.add(a.getDate()[i]);
        }
        System.out.println(a);
        return list;
    }

    //@ResponseBody와 ResponseEntity를 return하는거나 같은 결과이지만 구현방법이 틀릴 뿐이다.
    @ResponseBody// 통신 메시지 관련 header와 body의 값들을 하나의 객체로 저장하는 것이 HttpEntity 클래스 객체,Request 부분일 경우 HttpEntity를 상속받은 RequestEntity가, Response 부분일 경우 HttpEntity를 상속받은 ResponseEntity가 하게
    @RequestMapping(value ="/api/test", method = RequestMethod.POST)// RestTemplate 이용하여 Flask에 접속
    public ResponseEntity<instarDto[]> json2(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception
    {
        request.setCharacterEncoding("UTF-8");
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String,String> map = new HashMap<>();
        String url = "http://localhost:5000/mongoTest";
        //map.put("classes",post.get("classes").toString());//request로 날아오는것에서 원하는 정보 빼줌

        HttpEntity<?> entity = new HttpEntity<>(map);
        //String responseEntity = restTemplate.getForObject(url, String.class, map);

        ResponseEntity<instarDto[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, instarDto[].class);
        System.out.println(responseEntity);

        return responseEntity;
    }
}
