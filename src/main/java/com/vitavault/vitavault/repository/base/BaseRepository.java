package com.vitavault.vitavault.repository.base;

import com.vitavault.vitavault.model.domain.base.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, UUID> {
    default List<E> getAll () {
        return (List<E>) findAll();
    }
}
