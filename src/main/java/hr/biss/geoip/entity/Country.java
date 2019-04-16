package hr.biss.geoip.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="country_ip_info")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    @Column(name = "country_name")
    private String name;

    public Country() {
    }

    public Country(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

}
