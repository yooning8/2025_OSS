package com.example.re_wear.controller;

import com.example.re_wear.dto.SignUpDTO;
import com.example.re_wear.dto.LoginDTO;
import com.example.re_wear.entity.User;
import com.example.re_wear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/signup.html";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute SignUpDTO dto) {
        try {
            User user = new User(
                    dto.getUserId(),
                    dto.getEmail(),
                    dto.getPassword(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getAddressZipcode()
            );
            userService.saveUser(user);
            return "redirect:/login.html";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup.html?error=true";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@ModelAttribute LoginDTO dto) {
        boolean success = userService.verifyLogin(dto.getUserId(), dto.getPassword());
        return success ? "로그인 성공" : "로그인 실패: 아이디 또는 비밀번호 오류";
    }

    // 🔹 사용자 정보 수정
    @PostMapping("/info/{userId}")
    @ResponseBody
    public String updateUserInfo(@PathVariable String userId, @ModelAttribute User user) {
        User existing = userService.getUserById(userId);
        if (existing == null) return "사용자 없음";
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setAddress(user.getAddress());
        existing.setAddressZipcode(user.getAddressZipcode());
        userService.saveUser(existing);
        return "수정 완료";
    }

    // ✅ 사용자 정보 조회용 GET 메서드 추가
    @GetMapping("/info/{userId}")
    @ResponseBody
    public User getUserInfo(@PathVariable String userId) {
        return userService.getUserById(userId);
    }
}
