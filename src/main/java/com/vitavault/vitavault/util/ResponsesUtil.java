package com.vitavault.vitavault.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponsesUtil {
    public ResponseEntity<String> badRequest (String message) {
        return ResponseEntity.badRequest().body(message);
    }

    public ResponseEntity<String> ok (String message) {
        return ResponseEntity.ok(message);
    }

    public ResponseEntity<String> internalError(String message, Exception error) {
        return ResponseEntity.internalServerError().body(message + error);
    }

    public ResponseEntity<String> notFound(String message) {
        return ResponseEntity.status(404).body(message);
    }

    public ResponseEntity<String> unauthorized (String message) {
        return ResponseEntity.status(401).body(message);
    }

    public ResponseEntity<Object> okWithObject (Object object) {
        return ResponseEntity.ok(object);
    }
}
