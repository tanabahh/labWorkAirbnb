package itmo.airbnb.dto.response;

import java.util.List;

public class SearchResponse {

    private List<ListingDto> listings;

    public List<ListingDto> getListings() {
        return listings;
    }

    public void setListings(List<ListingDto> listings) {
        this.listings = listings;
    }
}
