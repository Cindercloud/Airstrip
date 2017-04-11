package cloud.cinder.airstrip.config.auth0;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginRefererFilter extends GenericFilterBean {

    private static final String FORBIDDEN_URL = "/403";

    private static final String REFERER_URL = "cinder.cloud.auth.referer-url";

    @Value("${cloud.cinder.switch.base-url}")
    private String switchBaseUrl;

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        if (FORBIDDEN_URL.equals(request.getRequestURI())) {
            request.setAttribute(REFERER_URL, switchBaseUrl + getPreviouslySavedUrl(request));
        } else {
            request.getSession(true).setAttribute(REFERER_URL, request.getRequestURI());
        }
        chain.doFilter(request, response);
    }

    private String getPreviouslySavedUrl(final HttpServletRequest request) {
        if (request.getSession().getAttribute(REFERER_URL) != null) {
            return request.getSession().getAttribute(REFERER_URL).toString();
        } else {
            return "";
        }
    }
}
