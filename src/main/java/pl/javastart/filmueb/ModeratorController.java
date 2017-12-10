package pl.javastart.filmueb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModeratorController {
    @ResponseBody
    @GetMapping("/moderator")
    public String moderator(){
        return "moderator";
    }
}
