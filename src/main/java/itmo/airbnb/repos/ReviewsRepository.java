package itmo.airbnb.repos;

import itmo.airbnb.domain.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
}
