package com.th.ask.service.implementation;

import com.th.ask.model.City;
import com.th.ask.model.Weather;
import com.th.ask.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private RestTemplate restTemplate;

    @PostConstruct
    public void postConstruct() {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Weather getWeather(City city) {
        if(city == null) {
            city = City.KRAKOW;
        }
        String url = apiUrl + "/current.json?key={0}&q={1}&aqi=no";
        return this.restTemplate.getForObject(url, Weather.class, apiKey, city.getApiValue());
    }
}
