package hr.biss.geoip.resource;

import hr.biss.geoip.entity.Country;
import hr.biss.geoip.entity.CountryReq;
import hr.biss.geoip.model.CountryInfo;
import hr.biss.geoip.resource.dto.CountryDto;
import hr.biss.geoip.service.CountryReqService;
import hr.biss.geoip.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/country")
public class CountryResource {

    private static final Logger logger = LoggerFactory.getLogger(CountryResource.class);

    private RestTemplate restTemplate;

    private CountryService countryService;

    private CountryReqService reqService;

    @Autowired
    public CountryResource(RestTemplate restTemplate, CountryService countryService, CountryReqService reqService) {
        this.restTemplate = restTemplate;
        this.countryService = countryService;
        this.reqService = reqService;
    }

    @Value("${geo-ip.url}")
    private String geoIpUrl;

    @GetMapping
    @Cacheable("countryInfo")
    public ResponseEntity<CountryInfo> getCountryInfoByIp(@NotNull @RequestParam String ip) {

        logger.info("REST request to get country info for ip : {}", ip);

        // save request in DB
        reqService.save(new CountryReq(ip));

        ResponseEntity<CountryDto> responseEntity = restTemplate.getForEntity(geoIpUrl + ip +"/json/", CountryDto.class);
        CountryDto countryDto = responseEntity.getBody();

        if (countryDto == null || countryDto.getCountry() == null) {
            logger.warn("invalid ip address : {}", ip);
            return new ResponseEntity<>(new CountryInfo(ip, null), HttpStatus.NOT_FOUND);
        }

        // save ib DB
        Country country = new Country(ip, countryDto.getCountry());
        countryService.save(country);

        // response
        CountryInfo countryInfo = new CountryInfo(countryDto.getIp(), countryDto.getCountry());

        return new ResponseEntity<>(countryInfo, HttpStatus.OK);
    }

    @GetMapping(value = "/requests", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTotalRequest() {

        logger.info("REST request to get the total number of requests");

        int total = reqService.getTotalRequests();
        String body = "{\"total\": " + total + "}";

        return new ResponseEntity<>(body, HttpStatus.OK);

    }

}
