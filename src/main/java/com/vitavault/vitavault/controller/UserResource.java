package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.User;
import com.vitavault.vitavault.service.user.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/user")
@CrossOrigin(origins = "*")
public class UserResource extends BaseControllerImpl<User, UserServiceImpl> {
}
