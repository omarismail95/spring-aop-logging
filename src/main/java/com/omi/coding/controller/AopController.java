package com.omi.coding.controller;

import com.omi.coding.config.annotation.LogExecutionTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Aop Controller Class.
 *
 * @author Omar Ismail
 * @since 5/18/2022
 */
@RestController
public class AopController {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/hello"
    )
    @LogExecutionTime
    public ResponseEntity<?> getHello(
            @RequestParam("name") String username
    ) {
        return ResponseEntity.ok("Hello, " + username);
    }

}
