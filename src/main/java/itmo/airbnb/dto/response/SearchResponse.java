package itmo.airbnb.dto.response;

import java.util.List;

public class SearchResponse {

    private List<ListingSearchDto> listings;

    public List<ListingSearchDto> getListings() {
        return listings;
    }

    public void setListings(List<ListingSearchDto> listings) {
        this.listings = listings;
    }
}
