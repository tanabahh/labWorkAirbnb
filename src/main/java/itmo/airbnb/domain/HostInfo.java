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
    private Integer infoId;

    @Column
    private Integer hostId;

    @Column(precision = 2, scale = 1)
    private BigDecimal responserate;

    @Column(precision = 2, scale = 1)
    private BigDecimal hostrating;

    @Column
    private OffsetDateTime ddtmValidFrom;

    @Column
    private OffsetDateTime dttmValidTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_idd_id")
    private Host hostIdd;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(final Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(final Integer hostId) {
        this.hostId = hostId;
    }

    public BigDecimal getResponserate() {
        return responserate;
    }

    public void setResponserate(final BigDecimal responserate) {
        this.responserate = responserate;
    }

    public BigDecimal getHostrating() {
        return hostrating;
    }

    public void setHostrating(final BigDecimal hostrating) {
        this.hostrating = hostrating;
    }

    public OffsetDateTime getDdtmValidFrom() {
        return ddtmValidFrom;
    }

    public void setDdtmValidFrom(final OffsetDateTime ddtmValidFrom) {
        this.ddtmValidFrom = ddtmValidFrom;
    }

    public OffsetDateTime getDttmValidTo() {
        return dttmValidTo;
    }

    public void setDttmValidTo(final OffsetDateTime dttmValidTo) {
        this.dttmValidTo = dttmValidTo;
    }

    public Host getHostIdd() {
        return hostIdd;
    }

    public void setHostIdd(final Host hostIdd) {
        this.hostIdd = hostIdd;
    }

}
