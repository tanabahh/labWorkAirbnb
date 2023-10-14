package itmo.airbnb.repos;

import itmo.airbnb.domain.ListingInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListingInfoRepository extends JpaRepository<ListingInfo, Long> {
}
