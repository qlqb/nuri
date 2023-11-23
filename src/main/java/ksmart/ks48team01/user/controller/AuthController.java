package ksmart.ks48team01.user.controller;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
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

    // 이메일과 회원이름을 조회하여 아이디를 반환하기 위한 입력폼
    @GetMapping("/findMyId")
    public String findMyId() {

        return "user/auth/findMyId";
    }


    // redirectAttribute를 사용하여 로그인 페이지에 찾은 회원 아이디 redirect
    @ResponseBody
    @PostMapping("/findMyId")
    public Map<String, Object> findMyId(@RequestBody Map<String, String> findRequest) {
        String userName = findRequest.get("userName");
        String userEmail = findRequest.get("userEmail");
        String findResponse = userService.findMyId(userName, userEmail);
        Map<String, Object> resultMap = new HashMap<>();
        if(findResponse != null) {
            resultMap.put("resultValue", true);
            resultMap.put("resultMessage", findResponse);
        } else {
            resultMap.put("resultValue", false);
            resultMap.put("resultMessage", "일치하는 회원의 정보가 없습니다.");
        }
        return resultMap;
    }

    /**
     * 비밀번호 찾기 페이지 요청
     * @return 비밀번호 찾기 페이지
     */
    @GetMapping("/findMyPw")
    public String findMyPw() {

        return "user/auth/findMyPw";
    }

    @ResponseBody
    @PostMapping("/findMyPw")
    public int findMyPw(@RequestBody Map<String, String> findRequest) {
        String userId = findRequest.get("userId");
        String userContact = findRequest.get("userContact");
        return userService.findMyPw(userId, userContact);
    }

    @PostMapping("/resetPage")
    public String resetPage(@RequestParam(name = "resetUserId") String resetUserId, RedirectAttributes reAttr) {

        reAttr.addFlashAttribute("identifier", resetUserId);

        return "redirect:/user/auth/resetMyPw";
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
