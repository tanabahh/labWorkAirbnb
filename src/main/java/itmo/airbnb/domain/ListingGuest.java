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
import java.time.OffsetDateTime;


@Entity
public class ListingGuest {

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

    @Column
    private Integer guestId;

    @Column
    private OffsetDateTime loadDdtm;

    @Column
    private Integer sourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_idd_id")
    private Listing listingIdd;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(final Integer listingId) {
        this.listingId = listingId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(final Integer guestId) {
        this.guestId = guestId;
    }

    public OffsetDateTime getLoadDdtm() {
        return loadDdtm;
    }

    public void setLoadDdtm(final OffsetDateTime loadDdtm) {
        this.loadDdtm = loadDdtm;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(final Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Listing getListingIdd() {
        return listingIdd;
    }

    public void setListingIdd(final Listing listingIdd) {
        this.listingIdd = listingIdd;
    }

}
