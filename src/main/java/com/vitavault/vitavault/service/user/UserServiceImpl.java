package com.vitavault.vitavault.service.user;

import com.vitavault.vitavault.model.domain.User;
import com.vitavault.vitavault.model.input.InputUser;
import com.vitavault.vitavault.repository.UserRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.service.center.ICenterService;
import com.vitavault.vitavault.service.person.IPersonService;
import com.vitavault.vitavault.service.role.IRoleService;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements IUserService {
    private final String className = User.class.getName();

    @Autowired
    private ICenterService centerService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IRoleService roleService;

    @Override
    public void create(InputUser input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("password", input.password()), className);
        requestValidator.invalidRequest(new Property("active", input.active()), className);
        requestValidator.invalidRequest(new Property("center", input.center()), className);
        requestValidator.invalidRequest(new Property("person", input.person()), className);
        requestValidator.invalidRequest(new Property("role", input.role()), className);

        repository.save(
                User.builder()
                        .password(input.password())
                        .active(input.active())
                        .center(centerService.getByID(input.center()))
                        .person(personService.getByID(input.person()))
                        .role(roleService.getByID(input.role()))
                        .build()
        );
    }

    @Override
    public void update(UUID id, InputUser input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        User user = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isStrongPassword(input.password()))
            user.setPassword(input.password());

        if (validate.isBoolean(input.active()))
            user.setActive(input.active());

        if (validate.isUUID(input.center()))
            user.setCenter(centerService.getByID(input.center()));

        if (validate.isUUID(input.person()))
            user.setPerson(personService.getByID(input.person()));

        if (validate.isUUID(input.role()))
            user.setRole(roleService.getByID(input.role()));

        repository.save(user);
    }
}
