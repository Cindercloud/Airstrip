package cloud.cinder.switchapp.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/")
@Controller
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "coming-soon/coming-soon";
    }
}
