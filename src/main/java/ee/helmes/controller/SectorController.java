package ee.helmes.controller;

import ee.helmes.service.SectorService;
import ee.helmes.domain.Sector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/sector")
@Slf4j
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping(path = "/all",
                produces = "application/json")
    public @ResponseBody Iterable<Sector> getAllSectors() {
        return sectorService.getAllSectors();
    }

}

