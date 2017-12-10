package pl.javastart.filmueb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }



//    @ResponseBody
//    @GetMapping("/encode")
//    public void encode(@RequestParam String password) {
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(password);
//
//        User user = new User();
//        user.setPassword(encodedPassword);
//    }
}