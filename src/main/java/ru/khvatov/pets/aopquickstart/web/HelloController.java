package ru.khvatov.pets.aopquickstart.web;

import static java.util.Objects.nonNull;

import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.khvatov.pets.aopquickstart.dto.NoteDto;

@RequestMapping(path = "/api/v1/greetings")
@RestController
public class HelloController {
    @GetMapping
    public Map<String, Object> hello(
        @RequestParam(required = false, name = "name") String name,
        NoteDto note
    ) {
        if (nonNull(name) && name.equals("throwError")) {
            throw new RuntimeException("Просили бросить эксепшен. Так вот он я!");
        }
        
        return Map.of("message", String.format(
                "Hello, %s. Note: %s",
                Objects.requireNonNullElse(name, "Мир"),
                Objects.requireNonNullElse(note, "Заметка отсуствует")
            )
        );
    }
}
