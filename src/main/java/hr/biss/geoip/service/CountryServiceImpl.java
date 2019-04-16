package hr.biss.geoip.service;

import hr.biss.geoip.entity.Country;
import hr.biss.geoip.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void save(Country theCountry) {
        countryRepository.save(theCountry);
    }
}
