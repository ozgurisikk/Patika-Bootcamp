package dev.patika.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/")
public class TestController {
    @GetMapping("/")
    public String home(){

        return "Anasayfa";
    }
    @GetMapping("/about")
    public String about(){
        return "About";
    }

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable("userId")int user_id){
        return "User id : " + user_id;
    }
}
