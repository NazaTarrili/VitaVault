package com.vitavault.vitavault.service.user;

import com.vitavault.vitavault.model.domain.User;
import com.vitavault.vitavault.model.input.InputUser;
import com.vitavault.vitavault.repository.UserRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements IUserService {
    @Override
    public void create(InputUser input) {

    }

    @Override
    public void update(UUID id, InputUser input) {

    }
}
