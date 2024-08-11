package MVC.oht.Controller;

import MVC.oht.Records.recordMulta;
import MVC.oht.Service.servicePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/cadastro")
    public String cadastro(@RequestBody recordMulta recordMulta) {
        return "cadastro";
    }

    @GetMapping("/loby/{npage}/{nperpage}/{option}")
    public String loby(@RequestBody recordMulta multa,@PathVariable int npage,@PathVariable int nperpage,@PathVariable int option,Model model) {
        var lista = servicePrincipal.realiseAll(multa,npage,nperpage,option);
        model.addAttribute();

        return "loby";
    }
    
}
