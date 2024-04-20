package com.vitavault.vitavault.controller.base;

import com.vitavault.vitavault.domain.base.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

interface IBaseController<E extends BaseEntity> {
    ResponseEntity<?> create(@RequestBody E entity);
    ResponseEntity<?> getAll();
    ResponseEntity<?> getByID(@PathVariable UUID id);
    ResponseEntity<?> update(@PathVariable UUID id, @RequestBody E entity);
    ResponseEntity<?> delete(@PathVariable UUID id);
}
