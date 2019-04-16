package hr.biss.geoip.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "country_ip_requests")
@Data
public class CountryReq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    @Column(name = "req_datetime")
    private ZonedDateTime dateTime;

    public CountryReq() {
    }

    public CountryReq(String ip) {
        this.ip = ip;
        this.dateTime = ZonedDateTime.now().withNano(0);
    }

}
