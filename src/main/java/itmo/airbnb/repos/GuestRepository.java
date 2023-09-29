package itmo.airbnb.repos;

import itmo.airbnb.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
