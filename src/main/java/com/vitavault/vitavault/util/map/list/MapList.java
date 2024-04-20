package com.vitavault.vitavault.util.map.list;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class MapList<T> implements IMapList<T> {
    @Override
    public List<T> mapEntities(List<UUID> entityIds, Function<UUID, T> getByIdFunction) {
        List<T> entities = new ArrayList<>();
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
