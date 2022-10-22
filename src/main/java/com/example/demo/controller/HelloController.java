package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//나는 컨트롤러야
@Controller
public class HelloController {

    @GetMapping("hello")
//    스피링이 지원하는 UI 라이브러리인 Model이 필요하다.
    public String hello(Model model){
        model.addAttribute("name", "seonguk");
        return "hello";
    }

//    @GetMapping("hello")
//    public String hello(@RequestParam(value="name")String name, Model model){
//        model.addAttribute("name", name);
//        return "hello";
//    }


    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(){
        return "hello-string";
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value="name")String name_input){
        Hello hello = new Hello();
        String name = name_input;
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;
        public  String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
