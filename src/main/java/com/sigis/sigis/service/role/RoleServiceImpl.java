package com.sigis.sigis.service.role;

import com.sigis.sigis.domain.Role;
import com.sigis.sigis.repository.RoleRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements IRoleService {
}
