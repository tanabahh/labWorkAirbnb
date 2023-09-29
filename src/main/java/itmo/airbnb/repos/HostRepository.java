package itmo.airbnb.repos;

import itmo.airbnb.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HostRepository extends JpaRepository<Host, Integer> {
}
