package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api") // Localhost:8080/api

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequst() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        String password = "bbbb";
        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);
        return id+pwd;
    }

    // 객체를 return 하면 jackson을 통해 객체를 jason으로 return 하라는 것.
    @GetMapping("/getMultiParameter") //http://localhost:8080/api/getMultiParameter?account=amapow&email=naver&page=1
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0 }
        return searchParam;
    }
}
