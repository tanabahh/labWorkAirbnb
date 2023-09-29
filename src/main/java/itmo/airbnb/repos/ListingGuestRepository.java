package itmo.airbnb.repos;

import itmo.airbnb.domain.ListingGuest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListingGuestRepository extends JpaRepository<ListingGuest, Integer> {
}
