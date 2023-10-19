package itmo.airbnb.dto.response.get;

import java.time.OffsetDateTime;
import java.util.Set;

public class HostListingGetDto {
    private String name;
    private String email;
    private String phone;
    private OffsetDateTime loadDdtm;
    private Long responseRate;
    private Long hostRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OffsetDateTime getLoadDdtm() {
        return loadDdtm;
    }

    public void setLoadDdtm(OffsetDateTime loadDdtm) {
        this.loadDdtm = loadDdtm;
    }

    public Long getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(Long responseRate) {
        this.responseRate = responseRate;
    }

    public Long getHostRating() {
        return hostRating;
    }

    public void setHostRating(Long hostRating) {
        this.hostRating = hostRating;
    }
}
