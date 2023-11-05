package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("registController")
@RequestMapping("/user/register")
public class registerController {

    // 가입 할 회원 권한을 선택할 수 있는 페이지
    // 권한 버튼에 따라서 쿼리스트링의 값이 바뀌고, 그 입력값에 따라 다른 가입 Form을 가져온다.
    @GetMapping(value = "/registerType")
    public String registerType(Model model) {

        model.addAttribute("title", "회원선택 - 누리컬쳐");

        return "user/register/registerType";
    }

    // Nuriculture 웹 애플리케이션을 이용하는 사용자(User) 권한의 가입 Form
    @GetMapping(value = "/memberRegister")
    public String memberRegister(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/register/memberRegister";
    }

    @PostMapping(value = "/memberRegister")
    public String memberRegister() {

        return "redirect:/user/register/registerConfirm";
    }

    // Nuriculture 웹 애플리케이션에서 상품을 판매, 게시하는 가맹점(store) 권한의 가입 Form
    @GetMapping(value = "/storeRegister")
    public String storeRegister(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/register/storeRegister";
    }


    @PostMapping(value = "/storeRegister")
    public String storeRegister() {

        return "redirect:/user/register/registerConfirm";
    }


    // Nuriculture 웹 애플리케이션을 이용, 관리하는 공무원(officer) 권한의 가입 Form
    @GetMapping(value = "/officerRegister")
    public String officerRegister(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/register/officerRegister";
    }


    /**
     * 
     * @param redirectAttributes redirect시, 권한에 따라 회원가입 페이지의 출력을 다르게 함
     * @return
     */
    @PostMapping(value = "/officerRegister")
    public String officerRegister(RedirectAttributes redirectAttributes) {

        //redirectAttributes.addAttribute("level", "공무원");

        return "redirect:/user/register/registerConfirm";
    }



    // 회원가입이 완료되었다는 것을 표시하는 페이지
    @GetMapping(value = "/registerConfirm")
    public String registerConfirm(Model model) {

        model.addAttribute("title", "회원가입 - 누리컬쳐");

        return "user/register/registerConfirm";
    }

//    @GetMapping(value = "/registerConfirm")
//    public String registerConfirm(@RequestParam("level") String userLevel, Model model) {
//
//        model.addAttribute("title", "회원가입 - 누리컬쳐");
//        model.addAttribute("userLevel", userLevel);
//
//        return "user/register/registerConfirm";
//    }



}