package itmo.airbnb.service;

import itmo.airbnb.domain.Calendar;
import itmo.airbnb.domain.Listing;
import itmo.airbnb.dto.response.ListingGetResponse;
import itmo.airbnb.dto.response.ListingSearchDto;
import itmo.airbnb.dto.response.SearchResponse;
import itmo.airbnb.repos.ListingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static itmo.airbnb.mapper.ListingMapper.mapGet;
import static itmo.airbnb.mapper.ListingMapper.mapSearch;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public SearchResponse search(String city, LocalDate startDate, LocalDate endDate, Integer priceMin, Integer priceMax) {
        ArrayList<ListingSearchDto> listingSearchDtos = new ArrayList<>();
        priceMin = priceMin == null ? 0 : priceMin;
        priceMax = priceMax == null ? Integer.MAX_VALUE : priceMax;
        List<Listing> listings = listingRepository.search(priceMin, priceMax, city);

        List<Listing> filteredListings = listings.stream().filter(listing -> listing.getCalendars().stream()
                .filter(calendar -> calendar.getCalendarDate().isAfter(startDate) && calendar.getCalendarDate().isBefore(endDate))
                .allMatch(Calendar::getAvailable)).toList();
        filteredListings.forEach(listing -> listingSearchDtos.add(mapSearch(listing)));
        var result = new SearchResponse();
        result.setListings(listingSearchDtos);
        return result;
    }

    public ListingGetResponse get(Long id) {
        return mapGet(listingRepository.findByIdFetch(id));
    }

}
