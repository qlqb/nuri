package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/auth")
public class AuthController {

    @GetMapping("/login")
    public String loginController() {

        return "user/auth/login";
    }

    @GetMapping("/findMyId")
    public String findMyId() {

        return "user/auth/findMyId";
    }

    @GetMapping("/findMyPw")
    public String findMyPw() {

        return "user/auth/findMyPw";
    }

    @GetMapping("/resetMyId")
    public String resetMyId() {

        return "user/auth/resetMyId";
    }



}
