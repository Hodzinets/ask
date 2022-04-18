package com.th.ask.model;

import lombok.Getter;

public enum City {
    KRAKOW("Krakow, Poland"),
    GDANSK("Gdansk, Poland"),
    WARSAW("Warsaw, Poland");

    @Getter
    private String apiValue;

    City(String apiValue) {
        this.apiValue = apiValue;
    }
}
