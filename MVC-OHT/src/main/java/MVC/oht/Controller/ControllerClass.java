package MVC.oht.Controller;

import MVC.oht.Service.servicePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/principal")
public class ControllerClass {

    @Autowired
    private servicePrincipal servicePrincipal;

    @GetMapping
    public String home (Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String home() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/loby")
    public String loby() {
        return "loby";
    }
    
}
