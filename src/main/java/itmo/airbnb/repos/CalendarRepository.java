package itmo.airbnb.repos;

import itmo.airbnb.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
