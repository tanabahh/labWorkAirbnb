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
public class ListingPrice {

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
    private Integer listingId;

    @Column(precision = 33, scale = 10)
    private BigDecimal prices;

    @Column
    private OffsetDateTime ddtmValidFrom;

    @Column
    private OffsetDateTime dttmValidTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listinf_idd_id")
    private Listing listinfIdd;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(final Integer listingId) {
        this.listingId = listingId;
    }

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(final BigDecimal prices) {
        this.prices = prices;
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

    public Listing getListinfIdd() {
        return listinfIdd;
    }

    public void setListinfIdd(final Listing listinfIdd) {
        this.listinfIdd = listinfIdd;
    }

}
