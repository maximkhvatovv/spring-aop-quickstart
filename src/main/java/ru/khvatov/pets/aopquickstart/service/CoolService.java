package ru.khvatov.pets.aopquickstart.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoolService {
    public void doCoolStuff() {
        log.info("Doing cool stuff ...");
    }
}
