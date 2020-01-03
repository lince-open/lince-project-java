package work.lince.commons.health.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import work.lince.commons.health.model.Health;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping(path = {"/", "/health"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Health health(Principal principal) {
        return Health.builder()
                .status("ok")
                .now(LocalDateTime.now())
                .user(principal.getName())
                .build();
    }


}