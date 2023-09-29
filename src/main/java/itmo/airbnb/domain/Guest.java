package itmo.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;


@Entity
public class Guest {

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
    private Integer guestId;

    @Column
    private Boolean name;

    @Column
    private OffsetDateTime ddtmValidFrom;

    @Column
    private OffsetDateTime dttmValidTo;

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(final Integer guestId) {
        this.guestId = guestId;
    }

    public Boolean getName() {
        return name;
    }

    public void setName(final Boolean name) {
        this.name = name;
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

}
