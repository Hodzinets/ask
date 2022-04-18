package com.th.ask.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WeatherController {
    @GetMapping("/weather")
    public String getWeather(Model model,
                             HttpServletRequest request,
                             @RequestParam(name = "city", required = false, defaultValue = "Krakow") String city) {

        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal =(KeycloakPrincipal)token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        var username = accessToken.getPreferredUsername();

        var temperature = 15;

        model.addAttribute("username", username);
        model.addAttribute("city", city);
        model.addAttribute("temperature", temperature);

        return "weather";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }
}
