package com.sigis.sigis.service.user;

import com.sigis.sigis.domain.User;
import com.sigis.sigis.repository.UserRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements IUserService {
}
