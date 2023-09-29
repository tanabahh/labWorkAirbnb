package itmo.airbnb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Host {

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
    private Integer hostId;

    @Column
    private Boolean name;

    @Column
    private Boolean email;

    @Column
    private Boolean phone;

    @Column
    private OffsetDateTime loadDdtm;

    @Column
    private Integer sourceId;

    @OneToMany(mappedBy = "hostIdd")
    private Set<Listing> listings;

    @OneToMany(mappedBy = "hostIdd")
    private Set<HostInfo> hostInfos;

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(final Integer hostId) {
        this.hostId = hostId;
    }

    public Boolean getName() {
        return name;
    }

    public void setName(final Boolean name) {
        this.name = name;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(final Boolean email) {
        this.email = email;
    }

    public Boolean getPhone() {
        return phone;
    }

    public void setPhone(final Boolean phone) {
        this.phone = phone;
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

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(final Set<Listing> listings) {
        this.listings = listings;
    }

    public Set<HostInfo> getHostInfos() {
        return hostInfos;
    }

    public void setHostInfos(final Set<HostInfo> hostInfos) {
        this.hostInfos = hostInfos;
    }

}
