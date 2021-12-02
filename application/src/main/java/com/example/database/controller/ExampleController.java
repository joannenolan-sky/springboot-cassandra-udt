package com.example.database.controller;

import com.example.database.model.http.ExampleRequest;
import com.example.database.model.http.ExampleResponse;
import com.example.database.service.CassandraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    private final CassandraService cassandraService;

    public ExampleController(CassandraService cassandraService) {
        this.cassandraService = cassandraService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ExampleResponse> add(@RequestBody ExampleRequest request) {

        cassandraService.update(request);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/remove")
    public ResponseEntity<?> remove(@RequestBody ExampleRequest request) {

        cassandraService.remove(request);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/retrieve/{id}")
    public ResponseEntity<?> retrieve(@PathVariable String id) {

        String response = cassandraService.get(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

}