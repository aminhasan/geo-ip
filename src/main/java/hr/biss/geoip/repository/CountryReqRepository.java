package hr.biss.geoip.repository;

import hr.biss.geoip.entity.CountryReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryReqRepository extends JpaRepository<CountryReq, Integer> {
}
