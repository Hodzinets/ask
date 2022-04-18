package com.th.ask.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Location{
    public String name;
    public String region;
    public String country;
}
