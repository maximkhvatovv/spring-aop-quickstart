package ru.khvatov.pets.aopquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.khvatov.pets.aopquickstart.service.CoolService;

@SpringBootApplication
public class AopQuickstartApp {

    public static void main(String[] args) {
        var context = SpringApplication.run(AopQuickstartApp.class, args);
        CoolService bean = context.getBean("coolService", CoolService.class);
        bean.doCoolStuff(2L, "Second");
        bean.doCoolStuff(1L, "First");
    }
}
