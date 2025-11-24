package lesson5_phamhoangnam_project3.lesson5_phamhoangnam_project3.controller;

import lesson5_phamhoangnam_project3.lesson5_phamhoangnam_project3.entity.PhnInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class phnController {

    @GetMapping("/")
    public String index() {
        return "index"; // load index.html
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // Tạo danh sách profile
        List<PhnInfo> profile = new ArrayList<>();
        profile.add(new PhnInfo(
                "Devmaster Academy",
                "dev",
                "contact@devmaster.edu.vn",
                "https://devmaster.edu.vn"
        ));

        // Đưa profile vào model
        model.addAttribute("DevmasterProfile", profile);

        return "profile"; // load profile.html
    }
}
