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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("SID");

        if(sessionId != null) {
            String sessionLevel = (String) session.getAttribute("SLEVEL");
            String requestURI = request.getRequestURI();

            return true;
        }

        response.sendRedirect("/user/auth/login");
        return false;
    }
}
