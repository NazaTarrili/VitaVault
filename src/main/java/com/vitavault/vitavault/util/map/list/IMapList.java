package com.vitavault.vitavault.util.map.list;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public interface IMapList<T> {
    List<T> mapEntities(List<UUID> entityId, Function<UUID, T> getByIdFunction);
}
