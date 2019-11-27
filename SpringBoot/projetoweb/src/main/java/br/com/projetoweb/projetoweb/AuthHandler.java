package br.com.projetoweb.projetoweb;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws IOException {
        if (!request.getRequestURI().equals("/usuario/login")) {
            HttpSession session = request.getSession();
            String accessToken = request.getHeader("access-token");
            if (session.getAttribute(accessToken) == null) {
                response.setStatus(401);
                return false;
            }
            return true;
        } else
            return true;
    }
}
