package itmo.airbnb.repos;

import itmo.airbnb.domain.HostInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HostInfoRepository extends JpaRepository<HostInfo, Long> {
}
