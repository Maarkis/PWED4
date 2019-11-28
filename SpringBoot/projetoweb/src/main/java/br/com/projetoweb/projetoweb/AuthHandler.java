package br.com.projetoweb.projetoweb;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthHandler extends HandlerInterceptorAdapter {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws IOException {
//        String clientSessionID = request.getHeader("session-id");
//        if (!request.getRequestURI().equals("/login") && !request.getMethod().equals("OPTIONS")) {
//            HttpSession session = request.getSession();
//            String userAccessToken = request.getHeader("access-token");
//            Object token = session.getAttribute("access-token");
//            if (userAccessToken == null || token == null) {
//                response.setStatus(401);
//                return false;
//            } else {
//                String sessionAccessToken = token.toString();
//                if (userAccessToken.equals(sessionAccessToken)) {
//                    return true;
//                }
//                response.setStatus(401);
//                return false;
//            }
//        } else
//            return true;
//
//    }

}
