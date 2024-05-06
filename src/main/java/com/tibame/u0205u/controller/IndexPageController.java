package com.tibame.u0205u.controller;

import com.tibame.u0205u.entity.DeptVO;
import com.tibame.u0205u.entity.EmpVO;
import com.tibame.u0205u.service.DeptService;
import com.tibame.u0205u.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexPageController {

    @Autowired
    private EmpService empSvc;

    @Autowired
    private DeptService deptSvc;

    // inject(注入資料) via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> myList =
            Arrays.asList(
                    "Spring Boot Quickstart 官網 : https://start.spring.io",
                    "IDE 開發工具",
                    "直接使用(匯入)官方的 Maven Spring-Boot-demo Project + pom.xml",
                    "直接使用官方現成的 @SpringBootApplication + SpringBootServletInitializer 組態檔",
                    "依賴注入(DI) HikariDataSource (官方建議的連線池)",
                    "Thymeleaf",
                    "Java WebApp (<font color=red>快速完成 Spring Boot Web MVC</font>)");

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("myList", myList);
        return "index";
    }

    @GetMapping("/hello")
    public String indexWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            Model model) {
        model.addAttribute("message", name);
        return "index"; // view
    }

    @GetMapping("/emp/select_page")
    public String select_page(Model model) {
        return "/emp/select_page";
    }

    @ModelAttribute("empListData")  // for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
    protected List<EmpVO> referenceListData(Model model) {
        List<EmpVO> list = empSvc.getAll();
        return list;
    }

    @ModelAttribute("deptListData") // for select_page.html 第135行用
    protected List<DeptVO> referenceListData_Dept(Model model) {
        model.addAttribute("deptVO", new DeptVO()); // for select_page.html 第133行用
        List<DeptVO> list = deptSvc.getAll();
        return list;
    }
}
