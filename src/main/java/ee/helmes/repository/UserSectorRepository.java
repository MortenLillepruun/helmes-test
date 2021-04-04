package ee.helmes.repository;

import ee.helmes.domain.UserSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSectorRepository extends JpaRepository<UserSector, Long> {

    void deleteAllByUserId(Long userId);
}
