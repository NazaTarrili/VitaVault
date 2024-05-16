package com.vitavault.vitavault.service.role;

import com.vitavault.vitavault.model.domain.Role;
import com.vitavault.vitavault.model.input.InputRole;
import com.vitavault.vitavault.repository.RoleRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements IRoleService {
    private final String className = Role.class.getName();

    @Override
    public void create(InputRole input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new Role("name"));
    }

    @Override
    public void update(UUID id, InputRole input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        Role role = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            role.setName(input.name());

        repository.save(role);
    }
}
