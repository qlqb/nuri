package ksmart.ks48team01.user.controller;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/user/auth")
public class AuthController {

    private UserService userService;

    public AuthController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginController() {

        return "user/auth/login";
    }

    @PostMapping("/login")
    public String loginController(@RequestParam(name = "userId") String userId,
                                  @RequestParam(name = "userPw") String userPw,
                                  HttpSession session,
                                  RedirectAttributes reAttr) {
        Map<String, Object> loginMap = userService.checkUserInfo(userId, userPw);
        boolean isChecked = (boolean) loginMap.get("isChecked");
        if(isChecked) {
            String userLevel = (String) loginMap.get("userLevel");

            session.setAttribute("SID", userId);
            session.setAttribute("SLEVEL", userLevel);

            return "redirect:/user";
        }

        reAttr.addFlashAttribute("msg", "일치하는 회원의 정보가 없습니다.");

        return "user/auth/login";
    }

    @GetMapping("/findMyId")
    public String findMyId() {

        return "user/auth/findMyId";
    }

    @GetMapping("/findMyPw")
    public String findMyPw(Model model) {

        return "user/auth/findMyPw";
    }

    @PostMapping("/findMyPw")
    public String findMyPw() {

        return "redirect:/user/auth/resetMyId";
    }

    @GetMapping("/resetMyPw")
    public String resetMyPw() {

        return "user/auth/resetMyPw";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/user";
    }



}
