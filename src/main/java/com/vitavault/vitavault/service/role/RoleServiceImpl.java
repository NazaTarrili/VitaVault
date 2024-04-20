package com.vitavault.vitavault.service.role;

import com.vitavault.vitavault.domain.Role;
import com.vitavault.vitavault.repository.RoleRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements IRoleService {
}
