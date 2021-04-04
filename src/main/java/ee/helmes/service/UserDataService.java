package ee.helmes.service;

import ee.helmes.common.UserDataRequest;
import ee.helmes.domain.UserData;
import ee.helmes.repository.UserDataRepository;
import ee.helmes.repository.UserSectorRepository;
import ee.helmes.domain.Sector;
import ee.helmes.domain.UserSector;
import ee.helmes.repository.SectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserSectorRepository userSectorRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Transactional
    public UserData save(UserDataRequest data) {
        UserData userData;
        if (data.getId() == null) {
            userData = new UserData();
        } else {
            Optional<UserData> optionalData = userDataRepository.findById(data.getId());
            userData = optionalData.orElseGet(UserData::new);
        }
        userData.setName(data.getName());
        userData.setTermsAgreement(data.isTermsAgreement());
        userDataRepository.save(userData);
        List<UserSector> sectors = saveSectors(data.getSectors(), userData);
        userData.setUserSectors(sectors);
        return userData;
    }

    private List<UserSector> saveSectors(List<Integer> sectors, UserData user) {
        List<UserSector> userSectors = new ArrayList<>();
        if (user.getId() != null) {
            userSectorRepository.deleteAllByUserId(user.getId());
        }

        for (Integer sectorValue : sectors) {
            UserSector userSector = new UserSector();
            userSector.setUser(user);
            Sector sector = sectorRepository.findByValue(sectorValue);
            userSector.setSector(sector);
            userSectors.add(userSector);
        }
        return userSectorRepository.saveAll(userSectors);
    }
}
