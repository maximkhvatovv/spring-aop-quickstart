package ru.khvatov.pets.aopquickstart.web;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1/intros")
@RestController
public class MyController {

    @GetMapping(path = "/{id}")
    public List<Map<String, Object>> getMyIntros(@PathVariable("id") Long id) {
        return List.of(
            Map.of("intro", "I'm Maxim Khvatov. Java Backend Developer.")
        );
    }
}
