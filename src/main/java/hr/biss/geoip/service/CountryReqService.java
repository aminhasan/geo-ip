package hr.biss.geoip.service;

import hr.biss.geoip.entity.CountryReq;

public interface CountryReqService {

    void save(CountryReq countryReq);

    int getTotalRequests();
}
