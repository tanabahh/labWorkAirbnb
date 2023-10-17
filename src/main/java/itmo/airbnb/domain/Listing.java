package itmo.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Listing {

    @Id
    @Column(name = "listing_id", nullable = false, updatable = false)
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
    private Long listingId;

    @Column(name = "load_ddtm")
    private OffsetDateTime loadDdtm;

    @Column(name = "city")
    private String city; //TODO say

    @Column(name = "source_id")
    private Integer sourceId; // TODO: ask

    @OneToMany(mappedBy = "listing")
    private Set<ListingInfo> listingInfos;

    @OneToMany(mappedBy = "listing")
    private Set<ListingPrice> listingPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private Host host;

    @OneToMany(mappedBy = "listing")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "listing")
    private Set<Calendar> calendars;

    @OneToMany(mappedBy = "listing")
    private Set<ListingGuest> listingGuests;


    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public OffsetDateTime getLoadDdtm() {
        return loadDdtm;
    }

    public void setLoadDdtm(OffsetDateTime loadDdtm) {
        this.loadDdtm = loadDdtm;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Set<ListingInfo> getListingInfos() {
        return listingInfos;
    }

    public void setListingInfos(Set<ListingInfo> listingInfos) {
        this.listingInfos = listingInfos;
    }

    public Set<ListingPrice> getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(Set<ListingPrice> listingPrice) {
        this.listingPrice = listingPrice;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(Set<Calendar> calendars) {
        this.calendars = calendars;
    }

    public Set<ListingGuest> getListingGuests() {
        return listingGuests;
    }

    public void setListingGuests(Set<ListingGuest> listingGuests) {
        this.listingGuests = listingGuests;
    }
}
