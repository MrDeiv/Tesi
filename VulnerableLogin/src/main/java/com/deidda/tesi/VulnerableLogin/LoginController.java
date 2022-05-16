package com.deidda.tesi.VulnerableLogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    private static final Logger LOGGER = LogManager.getLogger(VulnerableLoginApplication.class);

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message;

        LOGGER.warn("Tentativo di accesso da parte di: " + request.getRemoteAddr());

        if (LoginValidator.auth(username, password)){
            LOGGER.info("Tentativo di accesso riuscito per " + request.getRemoteAddr() +
                    " con credenziali: [" + username+ "," +password+ "]");
            message = "Welcome " +username + ".";
            return new ModelAndView("welcome", "message", message);
        }else{
            LOGGER.warn("Tentativo di accesso non riuscito per " + request.getRemoteAddr());
            message = "Wrong username or password.";
            return new ModelAndView("errorPage", "message", message);
        }
    }
}
