package com.vitavault.vitavault.service.base;

import com.vitavault.vitavault.domain.base.BaseEntity;
import com.vitavault.vitavault.repository.base.BaseRepository;
import com.vitavault.vitavault.util.NotFoundException;
import com.vitavault.vitavault.util.nullPropertyNames.IGetNullPropertyNames;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public abstract class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository<E>> implements IBaseService<E> {
    @Autowired
    protected R repository;

    @Autowired
    private IGetNullPropertyNames nullPropertyNames;

    @Override
    public List<E> getAll() throws Exception {
        try {
            return repository.findAll(Sort.by("id"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E getByID(UUID id) throws Exception {
        try {
            return repository.findById(id).orElseThrow(NotFoundException::new);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean create(E entity) throws Exception {
        try {
            repository.save(entity);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean update(UUID id, E newEntity) throws Exception {
        try {
            E entity = repository.findById(id).orElseThrow(NotFoundException::new);
            BeanUtils.copyProperties(newEntity, entity, nullPropertyNames.exec(newEntity));
            repository.save(entity);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            }
            throw new NotFoundException();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
