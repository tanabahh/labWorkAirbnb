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
public class Review {

    @Id
    @Column(name = "review_id", nullable = false, updatable = false)
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
    private Long reviewId;

    @Column(name = "load_ddtm")
    private OffsetDateTime loadDdtm;

    @Column(name = "source_id")
    private Integer sourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id")
    private Listing listing;

    @OneToMany(mappedBy = "review_id")
    private Set<ReviewInfo> reviewInfos;


    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
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

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Set<ReviewInfo> getReviewsInfos() {
        return reviewInfos;
    }

    public void setReviewsInfos(Set<ReviewInfo> reviewInfos) {
        this.reviewInfos = reviewInfos;
    }
}
