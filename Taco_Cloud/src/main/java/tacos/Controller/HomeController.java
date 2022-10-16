package tacos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//被Webconfig代替了
//@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }
}
