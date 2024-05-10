package com.vitavault.vitavault.service.base;

import com.vitavault.vitavault.exception.NotFoundException;
import com.vitavault.vitavault.model.domain.base.BaseEntity;
import com.vitavault.vitavault.repository.base.BaseRepository;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public abstract class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements IBaseService<E> {
    @Autowired
    protected R repository;

    @Autowired
    private IValidateProperty validate;

    @Override
    @Transactional(readOnly = true)
    public List<E> getAll() {
        List<E> entityList = (List<E>) repository.findAll();
        if (!validate.isNonEmptyEntityList(entityList))
            throw new NotFoundException("Not found entities.");

        return entityList;
    }

    @Override
    @Transactional(readOnly = true)
    public E getByID(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not exists an entity with this ID."));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        if (repository.existsById(id))
            repository.deleteById(id);

        throw new NotFoundException("Not exists an entity with this ID.");
    }
}
