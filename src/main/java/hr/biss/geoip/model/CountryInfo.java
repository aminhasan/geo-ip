package hr.biss.geoip.model;

import lombok.Data;

@Data
public class CountryInfo {

    private String ip;

    private String country;

    public CountryInfo() {
    }

    public CountryInfo(String ip, String country) {
        this.ip = ip;
        this.country = country;
    }
}
