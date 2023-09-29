package itmo.airbnb.repos;

import itmo.airbnb.domain.ListingPrice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListingPriceRepository extends JpaRepository<ListingPrice, Integer> {
}
