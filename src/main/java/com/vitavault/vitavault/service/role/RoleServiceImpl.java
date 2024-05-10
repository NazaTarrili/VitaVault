package com.vitavault.vitavault.service.role;

import com.vitavault.vitavault.model.domain.Role;
import com.vitavault.vitavault.model.input.InputRole;
import com.vitavault.vitavault.repository.RoleRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements IRoleService {
    @Override
    public void create(InputRole input) {

    }

    @Override
    public void update(UUID id, InputRole input) {

    }
}
