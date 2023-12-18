package azuresites.randocam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}