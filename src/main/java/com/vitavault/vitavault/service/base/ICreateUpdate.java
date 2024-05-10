package com.vitavault.vitavault.service.base;

import java.util.UUID;

public interface ICreateUpdate<I> {
    void create(I input);

    void update(UUID id, I input);
}
