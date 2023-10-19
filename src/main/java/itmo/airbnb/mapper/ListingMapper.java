package itmo.airbnb.mapper;

import itmo.airbnb.domain.Listing;
import itmo.airbnb.dto.response.ListingGetResponse;
import itmo.airbnb.dto.response.ListingSearchDto;
import itmo.airbnb.dto.response.get.HostListingGetDto;
import itmo.airbnb.dto.response.get.ReviewListingGetDto;

import java.util.ArrayList;

public class ListingMapper {
    public static ListingSearchDto mapSearch(Listing listing) {
        var dto = new ListingSearchDto();
        dto.setId(listing.getListingId());
        dto.setCity(listing.getCity());
        dto.setPrice(listing.getPrice().getPrice());
        dto.setName(listing.getListingInfo().getListingName());
        dto.setRating(listing.getListingInfo().getRating());
        return dto;
    }

    public static ListingGetResponse mapGet(Listing listing) {
        var dto = new ListingGetResponse();
        dto.setId(listing.getListingId());
        dto.setCity(listing.getCity());
        dto.setName(listing.getListingInfo().getListingName());
        dto.setRating(listing.getListingInfo().getRating());
        dto.setPrice(listing.getPrice().getPrice());
        var host = new HostListingGetDto();
        host.setName(listing.getHost().getName());
        host.setEmail(listing.getHost().getEmail());
        host.setHostRating(listing.getHost().getHostInfo().getHostRating());
        host.setPhone(listing.getHost().getPhone());
        host.setLoadDdtm(listing.getHost().getLoadDdtm());
        host.setResponseRate(listing.getHost().getHostInfo().getResponseRate());
        dto.setHost(host);
        ArrayList<ReviewListingGetDto> reviews = new ArrayList<>();
        listing.getReviews().forEach(review -> {
            var reviewDto = new ReviewListingGetDto();
            reviewDto.setComments(review.getReviewInfo().getComments());
            reviewDto.setReviewerName(review.getReviewInfo().getReviewerName());
            reviewDto.setDatePublication(review.getReviewInfo().getDatePublication());
            reviews.add(reviewDto);
        });
        dto.setReview(reviews);
        return dto;
    }
}
