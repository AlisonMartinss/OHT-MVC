package MVC.oht.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/principal")
public class ControllerClass {

    @GetMapping
    public String hello (Model model) {
        return "home";
    }
}
