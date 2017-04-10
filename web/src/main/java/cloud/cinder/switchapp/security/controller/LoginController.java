package cloud.cinder.switchapp.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/403")
public class LoginController {

    @Value("${cloud.cinder.peapol.login-url}")
    private String peapolLoginurl;

    @RequestMapping(method = RequestMethod.GET)
    public String login(final HttpServletRequest req) {
        return "redirect:" + peapolLoginurl + "?redirectTo=" + getRedirectUrl(req);
    }

    private String getRedirectUrl(final HttpServletRequest request) {
        if (request.getAttribute("cinder.cloud.auth.referer-url") != null) {
            return request.getAttribute("cinder.cloud.auth.referer-url").toString();
        } else {
            return "";
        }
    }

}
