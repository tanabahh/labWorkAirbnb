package itmo.airbnb.repos;

import itmo.airbnb.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query(value = "select l from Listing l " +
            "left join fetch l.listingPrice p " +
            "left join fetch l.calendars c " +
            "left join fetch l.listingInfos i " + //TODO можно удалить
            "where l.city = :city and p.prices <= :price_max and p.prices >= :price_min")
    List<Listing> search(@Param("price_min") int priceMin, @Param("price_max") int priceMax, @Param("city") String city);
}
