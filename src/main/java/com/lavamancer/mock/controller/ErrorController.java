package com.lavamancer.mock.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {


    @GetMapping("/public/errors/bad-request")
    public ResponseEntity<ErrorMessage> getBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(400, "Bad Request"));
    }

    @GetMapping("/public/errors/unauthorized")
    public ResponseEntity<ErrorMessage> getUnauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage(401, "Unauthorized"));
    }

    @GetMapping("/public/errors/forbidden")
    public ResponseEntity<ErrorMessage> getForbidden() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorMessage(403, "Forbidden"));
    }

    @GetMapping("/public/errors/not-found")
    public ResponseEntity<ErrorMessage> getNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(404, "Not Found"));
    }

    @GetMapping("/public/errors/internal-server-error")
    public ResponseEntity<ErrorMessage> getInternalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(500, "Internal Server Error"));
    }

    @GetMapping("/public/errors/i-am-a-teapot")
    public ResponseEntity<ErrorMessage> getIAmATeapot() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(new ErrorMessage(418, "I am a Teapot :P"));
    }


    @Data
    @AllArgsConstructor
    public static class ErrorMessage {
        private Integer code;
        private String message;
    }

}
