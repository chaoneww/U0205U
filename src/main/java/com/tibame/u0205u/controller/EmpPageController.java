package com.tibame.u0205u.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpPageController {

    @GetMapping("/home") // localhost:8081/home
    public String getIndexPage(Model model) {
        return "home"; // 傳回 templates/home.html
    }

    @GetMapping("/emp/listAllEmp")
    public String getAllEmpPage(Model model) {
        return "/emp/emp-list";
    }

    @GetMapping("/emp/detail/{empno}")
    public String getDetailPage(Model model) {
        return "/emp/emp-detail";
    }

    @GetMapping("/emp/add")
    public String getAddPage(Model model) {
        return "/emp/emp-add"; // 傳回 templates/emp/update.html
    }

    @GetMapping("/emp/addEmp")
    public String getAddEmpPage(Model model) {
        return "/emp/emp-add"; // 傳回 templates/emp/update.html
    }

    @GetMapping("/emp/update")
    public String getUpdatePage(Model model) {
        return "/emp/emp-update"; // 傳回 templates/emp/update.html
    }
}
