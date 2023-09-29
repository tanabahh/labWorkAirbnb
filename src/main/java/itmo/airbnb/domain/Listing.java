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
    private Integer hostId;

    @Column
    private OffsetDateTime loadDdtm;

    @Column
    private Integer sourceId;

    @OneToMany(mappedBy = "listingIdd")
    private Set<ListingInfo> listingInfos;

    @OneToMany(mappedBy = "listinfIdd")
    private Set<ListingPrice> listingPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_idd_id")
    private Host hostIdd;

    @OneToMany(mappedBy = "listingIdd")
    private Set<Reviews> reviewss;

    @OneToMany(mappedBy = "listingIdd")
    private Set<Calendar> calendars;

    @OneToMany(mappedBy = "listingIdd")
    private Set<ListingGuest> listingGuests;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(final Integer listingId) {
        this.listingId = listingId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(final Integer hostId) {
        this.hostId = hostId;
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

    public Set<ListingInfo> getListingInfos() {
        return listingInfos;
    }

    public void setListingInfos(final Set<ListingInfo> listingInfos) {
        this.listingInfos = listingInfos;
    }

    public Set<ListingPrice> getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(final Set<ListingPrice> listingPrice) {
        this.listingPrice = listingPrice;
    }

    public Host getHostIdd() {
        return hostIdd;
    }

    public void setHostIdd(final Host hostIdd) {
        this.hostIdd = hostIdd;
    }

    public Set<Reviews> getReviewss() {
        return reviewss;
    }

    public void setReviewss(final Set<Reviews> reviewss) {
        this.reviewss = reviewss;
    }

    public Set<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(final Set<Calendar> calendars) {
        this.calendars = calendars;
    }

    public Set<ListingGuest> getListingGuests() {
        return listingGuests;
    }

    public void setListingGuests(final Set<ListingGuest> listingGuests) {
        this.listingGuests = listingGuests;
    }

}
