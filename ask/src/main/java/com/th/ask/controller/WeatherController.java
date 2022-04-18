package com.th.ask.controller;

import com.th.ask.model.City;
import com.th.ask.service.WeatherService;
import lombok.val;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/weather")
    public String getWeather(Model model,
                             HttpServletRequest request,
                             @RequestParam(name = "city", required = false, defaultValue = "KRAKOW") String city) {
        var weather = weatherService.getWeather(City.valueOf(city));

        model.addAttribute("username", getUsernameFromRequest(request));
        model.addAttribute("city", city);
        model.addAttribute("temperature", weather.current.temp_c);

        return "weather";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

    private String getUsernameFromRequest(HttpServletRequest request) {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal =(KeycloakPrincipal)token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        return accessToken.getPreferredUsername();
    }
}
