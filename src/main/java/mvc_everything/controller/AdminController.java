package mvc_everything.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.Admin;
import mvc_everything.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping
    public String Home(ModelMap model, @RequestParam(value = "message", required = false) String message) {
        model.addAttribute("message", message);
        return "admin/home";
    }

    @RequestMapping("/login")
    public String loginAdmin(ModelMap model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        model.addAttribute("title", "Login");
        return "admin/sign";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signInAdmin(@ModelAttribute Admin adminSession, ModelMap model) {
        if(adminService.validate(adminSession) == true) {
            return "admin/session";
        }
        else {
            return "redirect:/user?message=Username or Password is wrong!";
        }
    }

}
