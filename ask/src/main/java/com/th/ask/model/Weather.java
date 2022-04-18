package com.th.ask.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Weather{
    public Location location;
    public Current current;
}
