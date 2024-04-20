package com.vitavault.vitavault.util.map.set;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

@Component
public class MapSet<T> implements IMapSet<T> {
    @Override
    public Set<T> mapEntities(Set<UUID> entityIds, Function<UUID, T> getByIdFunction) {
        Set<T> entities = new HashSet<>();
        if (!entityIds.isEmpty()) {
            for (UUID id : entityIds) {
                T entity = getByIdFunction.apply(id);
                if (entity != null)
                    entities.add(entity);
            }
        }
        return entities;
    }
}
