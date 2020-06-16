package com.springbootdatabase.controller;

import com.springbootdatabase.model.*;
import com.springbootdatabase.service.BiyongService;
import com.springbootdatabase.service.DataService;
import com.springbootdatabase.service.MemberService;
import com.springbootdatabase.service.UpjongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MemberController {
    
    @Autowired
    private MemberService memberService;

//    @RequestMapping("/")
//    public String aaa(Model model)
//    {
//        System.out.println("x");
//
//        return "list";
//    }

    @RequestMapping("/api/list") //json test
    public List list()
    {
        List<MemberModel> member = memberService.printMember();
        //model.addAttribute("memberList",member);
        return member;
    }

    @RequestMapping("/api/addMember")//GET방식
    public String addMember(Model model)
    {
        return "addMember";
    }

    @RequestMapping(value="/api/insert", method= RequestMethod.POST)
    public String insert(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        member.setId(post.get("id").toString());
        member.setName(post.get("name").toString());
        member.setPassword(post.get("pw").toString());
        member.setAge(Integer.parseInt(post.get("age").toString()));

        memberService.insertMember(member);
//        ModelAndView result = new ModelAndView("redirect:/list");
        //굳이 ModelAndView객체를 사용한 이유는 말그대로 Model객체와 view에 넘겨줄 페이지값을 가진 return값을 합친것이다.얘를 사용하면 실행할 페이지이름을 지정해주거나 생성시 페이지의 이름 생성가능
        return "회원가입 완료"; //controller에서 할꺼 다 하고 view에 던져줄것.
    }

    @RequestMapping(value="/api/delete", method=RequestMethod.POST)
    public String delete(HttpServletRequest request) throws UnsupportedEncodingException{

        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();//새로운 모델객체를 생성한뒤
        member.setId((request.getParameter("id")));//POST방식으로 넘어온 정보들을 이 새로 생성된 객체안에 넣어주고
        member.setPassword((String)request.getParameter("password"));
        memberService.deleteMember(member);//그정보를 삭제해줌.->결국 쿼리문을 가르키고 있다.
        return "redirect:/list";
    }

    @RequestMapping("/api/updateMember")//여긴 jsp에서 받아오는 GET방식
    public String updateMember(Model model,HttpServletRequest request )
    {
        model.addAttribute("id",request.getParameter("id"));//처음 list에서 update되면서 넘겨줄때 id를 넘겨주기 위해서 add를 하여 추가해준다.jsp는 model을 사용하기 때문에
        return "updateMember";
    }

    @RequestMapping(value="/api/update", method=RequestMethod.POST)//jsp에서 사용되는 POST방식
    public String update(HttpServletRequest request) throws UnsupportedEncodingException{

        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        member.setId((request.getParameter("id")));
        member.setName((String)request.getParameter("name"));
        member.setPassword((String)request.getParameter("password"));
        member.setAge(Integer.parseInt(request.getParameter("age")));
        memberService.updateMember(member);

        return "redirect:/list";
    }

    @RequestMapping(value="/api/login" , method=RequestMethod.POST)
    public String login(@RequestBody final HashMap<String,Object> post ,HttpServletRequest request) throws  UnsupportedEncodingException
    {
        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        request.getSession().setAttribute("id",post.get("id").toString());//id를 잠시 보관해두기 위한 단계
        member.setId(post.get("id").toString());
        member.setPassword(post.get("pw").toString());
        System.out.println(post.get("id").toString());
        boolean result = memberService.loginMember(member);
        if(result)
        {
            return "su";//로그인 성공
        }
        return "re"; //로그인 실패
    }

    @RequestMapping(value="/api/checkId",method=RequestMethod.POST)
    public String checkId(@RequestBody final HashMap<String,Object> post, HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        System.out.println(post.get("id").toString());
        member.setId(post.get("id").toString());
        boolean result = memberService.checkId(member);
        if(result)
        {
            return "중복 안됨"; //중복 안된경우
        }
        else
        {
            return "중복임"; //중복인경우
        }
    }
}
