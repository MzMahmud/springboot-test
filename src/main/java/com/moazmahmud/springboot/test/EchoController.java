package com.moazmahmud.springboot.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/echo")
public class EchoController {
    @GetMapping
    public Map<String, String> echoFromQuery(
            HttpServletRequest request,
            @RequestParam String message
    ) {
        return Map.of("message", message);
    }

    @PostMapping("/time")
    public Map<String, Object> getTime(
            HttpServletRequest request,
            @RequestBody AskTime askTime
    ) {
        return Map.of(
                "message", "Hello " + askTime.name(),
                "time", LocalDateTime.now()
        );
    }
}
