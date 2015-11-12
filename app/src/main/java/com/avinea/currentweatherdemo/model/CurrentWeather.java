package com.avinea.currentweatherdemo.model;

import java.util.List;

/**
 * Created by joeyespinosa on 11/12/15.
 */
public class CurrentWeather {

    /**
     * lon : -0.13
     * lat : 51.51
     */

    private CoordEntity coord;
    /**
     * coord : {"lon":-0.13,"lat":51.51}
     * weather : [{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}]
     * base : stations
     * main : {"temp":288.25,"pressure":1021,"humidity":77,"temp_min":287.15,"temp_max":289.15}
     * visibility : 10000
     * wind : {"speed":6.2,"deg":210}
     * clouds : {"all":40}
     * dt : 1447332600
     * sys : {"type":1,"id":5091,"message":0.0216,"country":"GB","sunrise":1447312418,"sunset":1447344905}
     * id : 2643743
     * name : London
     * cod : 200
     */

    private String base;
    /**
     * temp : 288.25
     * pressure : 1021
     * humidity : 77
     * temp_min : 287.15
     * temp_max : 289.15
     */

    private MainEntity main;
    private int visibility;
    /**
     * speed : 6.2
     * deg : 210
     */

    private WindEntity wind;
    /**
     * all : 40
     */

    private CloudsEntity clouds;
    private int dt;
    /**
     * type : 1
     * id : 5091
     * message : 0.0216
     * country : GB
     * sunrise : 1447312418
     * sunset : 1447344905
     */

    private SysEntity sys;
    private int id;
    private String name;
    private int cod;
    /**
     * id : 802
     * main : Clouds
     * description : scattered clouds
     * icon : 03d
     */

    private List<WeatherEntity> weather;

    public void setCoord(CoordEntity coord) {
        this.coord = coord;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(MainEntity main) {
        this.main = main;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    public void setClouds(CloudsEntity clouds) {
        this.clouds = clouds;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setSys(SysEntity sys) {
        this.sys = sys;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setWeather(List<WeatherEntity> weather) {
        this.weather = weather;
    }

    public CoordEntity getCoord() {
        return coord;
    }

    public String getBase() {
        return base;
    }

    public MainEntity getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public WindEntity getWind() {
        return wind;
    }

    public CloudsEntity getClouds() {
        return clouds;
    }

    public int getDt() {
        return dt;
    }

    public SysEntity getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public static class CoordEntity {
        private double lon;
        private double lat;

        public void setLon(double lon) {
            this.lon = lon;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }
    }

    public static class MainEntity {
        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }

        public double getTemp() {
            return temp;
        }

        public int getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }
    }

    public static class WindEntity {
        private double speed;
        private int deg;

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        public double getSpeed() {
            return speed;
        }

        public int getDeg() {
            return deg;
        }
    }

    public static class CloudsEntity {
        private int all;

        public void setAll(int all) {
            this.all = all;
        }

        public int getAll() {
            return all;
        }
    }

    public static class SysEntity {
        private int type;
        private int id;
        private double message;
        private String country;
        private int sunrise;
        private int sunset;

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMessage(double message) {
            this.message = message;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public double getMessage() {
            return message;
        }

        public String getCountry() {
            return country;
        }

        public int getSunrise() {
            return sunrise;
        }

        public int getSunset() {
            return sunset;
        }
    }

    public static class WeatherEntity {
        private int id;
        private String main;
        private String description;
        private String icon;

        public void setId(int id) {
            this.id = id;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }
}
