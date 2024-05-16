package com.vitavault.vitavault.service.base;

import com.vitavault.vitavault.model.domain.base.BaseEntity;
import com.vitavault.vitavault.repository.base.BaseRepository;
import com.vitavault.vitavault.util.exceptionFactory.IExceptionFactory;
import com.vitavault.vitavault.util.genericInvalidRequestValidator.IInvalidRequestValidator;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public abstract class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements IBaseService<E> {
    @Autowired
    protected R repository;

    @Autowired
    protected IValidateProperty validate;

    @Autowired
    protected IExceptionFactory exceptionFactory;

    @Autowired
    protected IInvalidRequestValidator requestValidator;

    @Override
    @Transactional(readOnly = true)
    public List<E> getAll() {
        List<E> entityList = (List<E>) repository.findAll();

        if (!validate.isNonEmptyEntityList(entityList))
            exceptionFactory.throwEmptyList();

        return entityList;
    }

    @Override
    @Transactional(readOnly = true)
    public E getByID(UUID id) {
        return repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound());
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        if (repository.existsById(id))
            repository.deleteById(id);

        exceptionFactory.throwNotFound();
    }
}
