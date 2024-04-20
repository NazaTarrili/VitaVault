package com.vitavault.vitavault.service.user;

import com.vitavault.vitavault.domain.User;
import com.vitavault.vitavault.repository.UserRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements IUserService {
}
