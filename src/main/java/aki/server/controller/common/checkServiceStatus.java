package aki.server.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class checkServiceStatus {
    @ResponseBody
    @GetMapping("checkServiceStatus")
    public String checkServiceStatus() {
        return "Good job!";
    }
}
