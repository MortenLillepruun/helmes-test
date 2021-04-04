package ee.helmes.repository;

import ee.helmes.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

    Sector findByValue(Integer value);
}
