package itmo.airbnb.dto.response;

import itmo.airbnb.dto.response.get.HostListingGetDto;
import itmo.airbnb.dto.response.get.ReviewListingGetDto;

import java.util.List;

public class ListingGetResponse {

    private Long id;
    private Long price;
    private String name;
    private Long rating;
    private String city;
    private HostListingGetDto hostListingGetDto;
    private List<ReviewListingGetDto> reviewListingGetDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public HostListingGetDto getHostListingGetDto() {
        return hostListingGetDto;
    }

    public void setHostListingGetDto(HostListingGetDto hostListingGetDto) {
        this.hostListingGetDto = hostListingGetDto;
    }

    public List<ReviewListingGetDto> getReviewListingGetDtoList() {
        return reviewListingGetDtoList;
    }

    public void setReviewListingGetDtoList(List<ReviewListingGetDto> reviewListingGetDtoList) {
        this.reviewListingGetDtoList = reviewListingGetDtoList;
    }
}
