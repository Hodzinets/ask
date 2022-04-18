package com.th.ask.service;

import com.th.ask.model.City;
import com.th.ask.model.Weather;

public interface WeatherService {
    Weather getWeather(City city);
}
