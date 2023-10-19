package itmo.airbnb.repos;

import itmo.airbnb.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query(value = "select l from Listing l " +
            "left join fetch l.price p " +
            "left join fetch l.calendars c " +
            "left join fetch l.listingInfo i " + //TODO можно удалить
            "where l.city = :city and p.price <= :price_max and p.price >= :price_min")
    List<Listing> search(@Param("price_min") int priceMin, @Param("price_max") int priceMax, @Param("city") String city);

    @Query(value = "select l from Listing l " +
            "left join fetch l.price p " +
            "left join fetch l.listingInfo i " +
            "left join fetch l.host h " +
            "left join fetch l.reviews r " +
            "left join fetch h.hostInfo " +
            "left join fetch r.reviewInfo")
    Listing findByIdFetch(@Param("id") long id);
}
