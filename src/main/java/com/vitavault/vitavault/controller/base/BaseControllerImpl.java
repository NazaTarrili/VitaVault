package com.vitavault.vitavault.controller.base;

import com.vitavault.vitavault.domain.base.BaseEntity;
import com.vitavault.vitavault.repository.base.BaseRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseControllerImpl<E extends BaseEntity, S extends BaseServiceImpl<E, ? extends BaseRepository<E>>> implements IBaseController<E> {
    @Autowired
    protected S service;

    @Override
    @PostMapping
    public ResponseEntity<?> create(@RequestBody E entity) {
        try {
            if (service.create(entity))
                return ResponseEntity.status(HttpStatus.CREATED).build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(service.getByID(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody E entity) {
        try {
            if (service.update(id, entity))
                return ResponseEntity.status(HttpStatus.OK).build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            if(service.delete(id))
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
