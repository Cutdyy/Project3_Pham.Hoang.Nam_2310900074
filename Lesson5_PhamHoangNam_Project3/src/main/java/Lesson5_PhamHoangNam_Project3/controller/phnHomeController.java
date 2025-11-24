package Lesson5_PhamHoangNam_Project3.controller;

import Lesson5_PhamHoangNam_Project3.entity.PhnInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class phnHomeController {

    @GetMapping({"/", "/home"})
    public String phnHome(Model model) {
        model.addAttribute("title", "Devmaster::Home");
        return "phnHome"; // templates/phnHome.html
    }

    @GetMapping("/profile")
    public String phnProfile(Model model) {
        List<PhnInfo> profile = new ArrayList<>();
        profile.add(new PhnInfo(
                "Devmaster Academy",
                "dev",
                "contact@devmaster.edu.vn",
                "https://devmaster.edu.vn"
        ));
        model.addAttribute("DevmasterProfile", profile);
        model.addAttribute("title", "Devmaster::Profile");
        return "phnProfile"; // templates/phnProfile.html
    }
}
