package ksmart.ks48team01.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("SID");

        if(sessionId != null) {
            int sessionLevel = (int) session.getAttribute("SLEVEL");
            String requestURI = request.getRequestURI();

            if(sessionLevel == 2) {
                if(requestURI.indexOf("/admin/user") > -1 ||
                   requestURI.indexOf("/admin/officer") > -1 ||
                   requestURI.indexOf("/admin/store/storeList") > -1) {
                    response.sendRedirect("/admin");
                    return false;
                }
            } else if (sessionLevel == 3) {
                if(requestURI.indexOf("/admin/adminRegister") > -1) {
                    response.sendRedirect("/");
                    return false;
                }
            } else if (sessionLevel == 4) {
                if(requestURI.indexOf("/admin") > -1) {
                    response.sendRedirect("/");
                    return false;
                }
            }
            return true;
        }

        response.sendRedirect("/user/auth/login");
        return false;
    }
}
