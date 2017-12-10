package pl.javastart.filmueb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @ResponseBody
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        UserAndRoles userAndRoles = new UserAndRoles();
        model.addAttribute("newUser", userAndRoles);
        return "addUserForm";
    }

//    @PostMapping("/adduser")
//    @ResponseBody
//    private void encode(User user) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//    }



    @PostMapping("/addNewUser")
    public String addNewUser(UserAndRoles userToDb) {
        User user = new User();
        UserRole userRole = new UserRole();

        user.setUsername(userToDb.getUsername());
        user.setPassword(userToDb.getPassword());
        user.setEnabled(true);

        userRole.setUsername(userToDb.getUsername());
        userRole.setRole(userToDb.getRole());

        userRepository.save(user);
        roleRepository.save(userRole);
        return "redirect:/";


    }
}
