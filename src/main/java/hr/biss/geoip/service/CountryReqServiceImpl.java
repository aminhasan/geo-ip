package hr.biss.geoip.service;


import hr.biss.geoip.entity.CountryReq;
import hr.biss.geoip.repository.CountryReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryReqServiceImpl implements CountryReqService {

    private CountryReqRepository repository;

    @Autowired
    public CountryReqServiceImpl(CountryReqRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(CountryReq countryReq) {
        repository.save(countryReq);
    }

    @Override
    public int getTotalRequests() {
        return repository.findAll().size();
    }
}
