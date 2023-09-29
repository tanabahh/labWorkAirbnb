package itmo.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class HasingAlgoritm {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer hashalgoritmid;

    @Column
    private Boolean algoritmname;

    public Integer getHashalgoritmid() {
        return hashalgoritmid;
    }

    public void setHashalgoritmid(final Integer hashalgoritmid) {
        this.hashalgoritmid = hashalgoritmid;
    }

    public Boolean getAlgoritmname() {
        return algoritmname;
    }

    public void setAlgoritmname(final Boolean algoritmname) {
        this.algoritmname = algoritmname;
    }

}
