package itmo.airbnb.repos;

import itmo.airbnb.domain.ReviewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewsInfoRepository extends JpaRepository<ReviewsInfo, Integer> {
}
