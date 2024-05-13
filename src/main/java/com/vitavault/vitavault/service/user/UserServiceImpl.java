package com.vitavault.vitavault.service.user;

import com.vitavault.vitavault.model.domain.User;
import com.vitavault.vitavault.model.input.InputUser;
import com.vitavault.vitavault.repository.UserRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements IUserService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputUser input) {

    }

    @Override
    public void update(UUID id, InputUser input) {

    }
}
