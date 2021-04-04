package ee.helmes.controller;

import ee.helmes.common.UserDataRequest;
import ee.helmes.domain.UserData;
import ee.helmes.service.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/user")
@Slf4j
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping(produces = "application/json")
    public @ResponseBody
    ResponseEntity<UserData> saveUserData(@RequestBody UserDataRequest request) {
        UserData userData = userDataService.save(request);
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

}
