package com.nhnacademy.student.controller.user;

import com.nhnacademy.student.domain.LoginRequest;
import com.nhnacademy.student.domain.User;
import com.nhnacademy.student.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/", "", "user/login"})
public class UserLoginController {
    private final UserRepository userRepository;

    @ModelAttribute
    public User getUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }

        Object userObj = session.getAttribute("user");
        if (userObj == null) {
            return null;
        }

        return (User) userObj;
    }

    @GetMapping
    public String loginForm(Model model, User user, HttpServletRequest request) {
        if (Objects.nonNull(user)) {
            return "redirect:/student/list";
        }
        log.info("message:{}", model.getAttribute("message"));
        model.addAttribute("loginRequest", new LoginRequest());
        return "user/login";
    }

    @PostMapping("user/login")
    public String login(@Valid LoginRequest loginRequest, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        if (!userRepository.matches(loginRequest.getUserId(), loginRequest.getUserPassword())) {
            redirectAttributes.addFlashAttribute("message", "로그인 실패");
            return "redirect:/user/login";
        }

        request.getSession(true).setAttribute("user", userRepository.getUser(loginRequest.getUserId()));
        return "redirect:/student/list";
    }

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }
}
