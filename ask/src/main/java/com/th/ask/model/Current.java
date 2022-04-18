package com.th.ask.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Current{
    public double temp_c;
    public double temp_f;
    public int is_day;
    public Condition condition;
    public double wind_mph;
    public double wind_kph;
    public int wind_degree;
    public String wind_dir;
    public double pressure_mb;
    public double pressure_in;
    public int humidity;
    public int cloud;
    public double uv;
}
