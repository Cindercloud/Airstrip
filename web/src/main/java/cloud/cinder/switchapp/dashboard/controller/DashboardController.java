package cloud.cinder.switchapp.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(WebRequest request) {
        return "index";
    }

    @RequestMapping({"/user", "/me"})
    @ResponseBody
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
}
