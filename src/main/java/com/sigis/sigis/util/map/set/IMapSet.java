package com.sigis.sigis.util.map.set;

import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

public interface IMapSet<T> {
    Set<T> mapEntities(Set<UUID> entityIds, Function<UUID, T> getByIdFunction);
}
