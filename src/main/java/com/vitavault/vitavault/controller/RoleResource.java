package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Role;
import com.vitavault.vitavault.service.role.RoleServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/role")
@CrossOrigin(origins = "*")
public class RoleResource extends BaseControllerImpl<Role, RoleServiceImpl> {
}
