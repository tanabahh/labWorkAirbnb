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
import java.time.LocalDate;


@Entity
public class Calendar {

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
    private LocalDate calendarDate;

    @Column
    private Boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_idd_id")
    private Listing listingIdd;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(final Integer listingId) {
        this.listingId = listingId;
    }

    public LocalDate getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(final LocalDate calendarDate) {
        this.calendarDate = calendarDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(final Boolean available) {
        this.available = available;
    }

    public Listing getListingIdd() {
        return listingIdd;
    }

    public void setListingIdd(final Listing listingIdd) {
        this.listingIdd = listingIdd;
    }

}
