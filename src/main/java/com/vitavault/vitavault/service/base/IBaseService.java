package com.vitavault.vitavault.service.base;

import com.vitavault.vitavault.model.domain.base.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface IBaseService<E extends BaseEntity> {
    List<E> getAll();

    E getByID(UUID id);

    void delete(UUID id);
}
