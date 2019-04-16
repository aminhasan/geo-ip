package hr.biss.geoip.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryDto {

    private String ip;

    private String city;

    @JsonProperty("country_name")
    private String country;

    @JsonProperty("continent_code")
    private String continentCode;
}
