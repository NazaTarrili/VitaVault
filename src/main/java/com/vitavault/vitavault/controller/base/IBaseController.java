package com.vitavault.vitavault.controller.base;

import com.vitavault.vitavault.domain.base.BaseEntity;
import com.vitavault.vitavault.util.responses.ResponseFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface IBaseController<E extends BaseEntity> {
    ResponseEntity<ResponseFormatter> create(@RequestBody E entity);
    ResponseEntity<ResponseFormatter> getAll();
    ResponseEntity<ResponseFormatter> getByID(@PathVariable UUID id);
    ResponseEntity<ResponseFormatter> update(@PathVariable UUID id, @RequestBody E entity);
    ResponseEntity<ResponseFormatter> delete(@PathVariable UUID id);
}
