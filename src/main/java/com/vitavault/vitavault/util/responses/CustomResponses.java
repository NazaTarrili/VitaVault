package com.vitavault.vitavault.util.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomResponses {
    //BASIC
    public ResponseEntity<ResponseFormatter> created () {
        ResponseFormatter response = ResponseFormatter.builder().message("¡Entity created!").build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<ResponseFormatter> founded (Object object) {
        ResponseFormatter response = ResponseFormatter.builder().body(object).message("¡Entity founded!").build();
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    public ResponseEntity<ResponseFormatter> updated () {
        ResponseFormatter response = ResponseFormatter.builder().message("¡Entity updated!").build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    public ResponseEntity<ResponseFormatter> deleted () {
        ResponseFormatter response = ResponseFormatter.builder().message("¡Entity deleted!").build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    //ERROR
    public ResponseEntity<ResponseFormatter> badRequest () {
        ResponseFormatter response = ResponseFormatter.builder().message("¡Bad request!").build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    public ResponseEntity<ResponseFormatter> error(Exception e) {
        ResponseFormatter response = ResponseFormatter.builder().body(e).message(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public ResponseEntity<ResponseFormatter> notFounded() {
        ResponseFormatter response = ResponseFormatter.builder().message("¡Entity not found!").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    public ResponseEntity<ResponseFormatter> unauthorized () {
        ResponseFormatter response = ResponseFormatter.builder().message("¡Unauthorized request!").build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
