package work.lince.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = {"/","/health"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HealthController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String,String>  health() {
        HashMap<String,String> result = new HashMap();
        result.put("status","ok");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        result.put("currentPrincipalName", authentication.getName());

        return result;
    }



}