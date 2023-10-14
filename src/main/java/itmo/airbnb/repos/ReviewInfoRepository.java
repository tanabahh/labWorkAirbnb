package itmo.airbnb.repos;

import itmo.airbnb.domain.ReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewInfoRepository extends JpaRepository<ReviewInfo, Long> {
}
