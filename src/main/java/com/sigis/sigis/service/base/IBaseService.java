package com.sigis.sigis.service.base;

import com.sigis.sigis.domain.base.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface IBaseService<E extends BaseEntity> {
    boolean create(E entity) throws Exception;
    List<E> getAll() throws Exception;
    E getByID(UUID id) throws Exception;
    boolean update(UUID id, E entity) throws Exception;
    boolean delete(UUID id) throws Exception;
}
