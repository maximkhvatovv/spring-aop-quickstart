package ru.khvatov.pets.aopquickstart.service;

import java.util.EventObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoolService {

    public EventObject doCoolStuff(Long id, String name) {
        log.info("Trying to do cool stuff");
        if (id == 1L) {
            throw new UnsupportedOperationException("I'm just testing after throwing advice");
        }
        log.info("Doing cool stuff ...");
        return new EventObject("Success returning event has fired!");
    }
}
