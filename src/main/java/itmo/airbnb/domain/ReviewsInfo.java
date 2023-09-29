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
import java.time.OffsetDateTime;


@Entity
public class ReviewsInfo {

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
    private Integer reviewId;

    @Column
    private Boolean reviewerName;

    @Column
    private Boolean comments;

    @Column
    private LocalDate datePublication;

    @Column
    private OffsetDateTime ddtmValidFrom;

    @Column
    private OffsetDateTime dttmValidTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rewies_idd_id")
    private Reviews rewiesIdd;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(final Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Boolean getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(final Boolean reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Boolean getComments() {
        return comments;
    }

    public void setComments(final Boolean comments) {
        this.comments = comments;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(final LocalDate datePublication) {
        this.datePublication = datePublication;
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

    public Reviews getRewiesIdd() {
        return rewiesIdd;
    }

    public void setRewiesIdd(final Reviews rewiesIdd) {
        this.rewiesIdd = rewiesIdd;
    }

}
