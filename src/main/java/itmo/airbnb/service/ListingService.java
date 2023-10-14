package itmo.airbnb.service;

import itmo.airbnb.domain.Calendar;
import itmo.airbnb.domain.Listing;
import itmo.airbnb.repos.ListingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ListingService {

    private ListingRepository listingRepository;

    ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> search(String city, LocalDate startDate, LocalDate endDate, Integer priceMin, Integer priceMax) {
        priceMin = priceMin == null ? 0 : priceMin;
        priceMax = priceMax == null ? Integer.MAX_VALUE : priceMax;
        List<Listing> listings = listingRepository.search(priceMin, priceMax, city);

        return listings.stream().filter(listing -> listing.getCalendars().stream()
                .filter(calendar -> calendar.getCalendarDate().isAfter( startDate) && calendar.getCalendarDate().isBefore(endDate))
                .allMatch(Calendar::getAvailable)).toList();
    }

    public Listing get(Long id) {
        return listingRepository.findById(id).orElse(new Listing());
    }

}
