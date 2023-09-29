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
public class ListingInfo {

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
    private Boolean listingUrl;

    @Column
    private Boolean listingName;

    @Column
    private Boolean description;

    @Column
    private Boolean roomtype;

    @Column(precision = 33, scale = 10)
    private BigDecimal rating;

    @Column
    private Boolean photoUrl;

    @Column
    private OffsetDateTime ddtmValidFrom;

    @Column
    private OffsetDateTime dttmValidTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_idd_id")
    private Listing listingIdd;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(final Integer listingId) {
        this.listingId = listingId;
    }

    public Boolean getListingUrl() {
        return listingUrl;
    }

    public void setListingUrl(final Boolean listingUrl) {
        this.listingUrl = listingUrl;
    }

    public Boolean getListingName() {
        return listingName;
    }

    public void setListingName(final Boolean listingName) {
        this.listingName = listingName;
    }

    public Boolean getDescription() {
        return description;
    }

    public void setDescription(final Boolean description) {
        this.description = description;
    }

    public Boolean getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(final Boolean roomtype) {
        this.roomtype = roomtype;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(final BigDecimal rating) {
        this.rating = rating;
    }

    public Boolean getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(final Boolean photoUrl) {
        this.photoUrl = photoUrl;
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

    public Listing getListingIdd() {
        return listingIdd;
    }

    public void setListingIdd(final Listing listingIdd) {
        this.listingIdd = listingIdd;
    }

}
