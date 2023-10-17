package itmo.airbnb.service;

import itmo.airbnb.domain.Calendar;
import itmo.airbnb.domain.Listing;
import itmo.airbnb.dto.response.ListingDto;
import itmo.airbnb.dto.response.SearchResponse;
import itmo.airbnb.repos.ListingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListingService {

    private ListingRepository listingRepository;

    ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public SearchResponse search(String city, LocalDate startDate, LocalDate endDate, Integer priceMin, Integer priceMax) {
        ArrayList<ListingDto> listingDtos = new ArrayList<>();
        priceMin = priceMin == null ? 0 : priceMin;
        priceMax = priceMax == null ? Integer.MAX_VALUE : priceMax;
        List<Listing> listings = listingRepository.search(priceMin, priceMax, city);

        List<Listing> filteredListings = listings.stream().filter(listing -> listing.getCalendars().stream()
                .filter(calendar -> calendar.getCalendarDate().isAfter( startDate) && calendar.getCalendarDate().isBefore(endDate))
                .allMatch(Calendar::getAvailable)).toList();
        filteredListings.forEach(listing -> {
            var dto = new ListingDto();
            dto.setId(listing.getListingId());
            dto.setCity(listing.getCity());
            dto.setName(listing.getListingInfos().stream().findAny().get().getListingName());
            dto.setRating(listing.getListingInfos().stream().findAny().get().getRating());
            listingDtos.add(dto);
        });
        var result = new SearchResponse();
        result.setListings(listingDtos);
        return result;
    }

    public Listing get(Long id) {
        return listingRepository.findById(id).orElse(new Listing());
    }

}
