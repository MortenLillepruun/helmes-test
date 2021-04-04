package ee.helmes.service;

import ee.helmes.domain.Sector;
import ee.helmes.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public Iterable<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }
}
