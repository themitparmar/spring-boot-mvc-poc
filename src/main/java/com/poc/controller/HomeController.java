package com.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        String message = " Welcome to my page";

        model.addAttribute("appName", appName);
        model.addAttribute("message", message);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("username: " + auth.getName());

        return "login";
    }

    @GetMapping("/home")
    public String dashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("username:" + auth.getName());

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/tasks")
    public String user() {
        return "redirect:/getAllTasks";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(null != auth) {
            String username = auth.getName();
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
