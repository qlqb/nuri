package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("registController")
@RequestMapping("/user/regist")
public class RegistController {

    // 가입 할 회원 권한을 선택할 수 있는 페이지
    // 권한 버튼에 따라서 쿼리스트링의 값이 바뀌고, 그 입력값에 따라 다른 가입 Form을 가져온다.
    @GetMapping(value = "/registType")
    public String registType(Model model) {

        model.addAttribute("title", "회원선택 - 누리컬쳐");

        return "user/regist/registTerms";
    }

    // 회원 가입 시 이용약관의 동의를 체크하는 페이지
    @GetMapping(value = "/registTerms")
    public String registTerms(Model model) {

        model.addAttribute("title", "약관동의 - 누리컬쳐");

        return "user/regist/registTerms";
    }

    // Nuriculture 웹 애플리케이션을 이용하는 사용자(User) 권한의 가입 Form
    @GetMapping(value = "/memberRegister")
    public String memberRegister(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/regist/memberRegister";
    }

    // Nuriculture 웹 애플리케이션에서 상품을 판매, 게시하는 가맹점(store) 권한의 가입 Form
    @GetMapping(value = "/storeRegister")
    public String storeRegister(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/regist/storeRegister";
    }

    // Nuriculture 웹 애플리케이션을 이용, 관리하는 공무원(officer) 권한의 가입 Form
    @GetMapping(value = "/officerRegister")
    public String officerRegister(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/regist/officerRegister";
    }

    // 회원가입이 완료되었다는 것을 표시하는 페이지
    @GetMapping(value = "/registConfirm")
    public String registConfirm(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/regist/registConfirm";
    }




}