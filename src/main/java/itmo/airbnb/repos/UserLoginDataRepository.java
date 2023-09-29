package itmo.airbnb.repos;

import itmo.airbnb.domain.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserLoginDataRepository extends JpaRepository<UserLoginData, Integer> {
}
