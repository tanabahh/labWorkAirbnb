package itmo.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Entity
public class HostInfo {

    @Id
    @Column(name = "info_id", nullable = false, updatable = false)
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
    private Long infoId;

    @Column(name = "response_rate", precision = 2, scale = 1)
    private Long responseRate;

    @Column(name = "host_rating", precision = 2, scale = 1)
    private Long hostRating;

    @Column(name = "ddtm_valid_from")
    private OffsetDateTime ddtmValidFrom;

    @Column(name = "dttm_valid_to")
    private OffsetDateTime dttmValidTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private Host hostIdd;

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(Long responseRate) {
        this.responseRate = responseRate;
    }

    public Long getHostRating() {
        return hostRating;
    }

    public void setHostRating(Long hostRating) {
        this.hostRating = hostRating;
    }

    public OffsetDateTime getDdtmValidFrom() {
        return ddtmValidFrom;
    }

    public void setDdtmValidFrom(OffsetDateTime ddtmValidFrom) {
        this.ddtmValidFrom = ddtmValidFrom;
    }

    public OffsetDateTime getDttmValidTo() {
        return dttmValidTo;
    }

    public void setDttmValidTo(OffsetDateTime dttmValidTo) {
        this.dttmValidTo = dttmValidTo;
    }

    public Host getHostIdd() {
        return hostIdd;
    }

    public void setHostIdd(Host hostIdd) {
        this.hostIdd = hostIdd;
    }
}
