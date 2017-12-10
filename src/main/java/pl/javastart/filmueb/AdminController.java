package pl.javastart.filmueb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private RoleRepository roleRepository;

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/changeRoles")
    public String changeRolesByAdmin (Model model, Model emptyModel) {
        List<UserRole> allRoles = roleRepository.findAll();
        model.addAttribute("allroles", allRoles);
        emptyModel.addAttribute("role", new UserRole());
        return "changeRolesByAdmin";
    }

    @PostMapping("/changeOneRole")
    private String changeOneRole(UserRole userRole) {
        if (userRole.getUsername() != null) {
            UserRole userRole1 = roleRepository.findByUsername(userRole.getUsername());
            userRole1.setRole(userRole.getRole());
            roleRepository.save(userRole1);
        }
        return "redirect:/";
    }

}
