package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.SocialWork;
import com.vitavault.vitavault.service.socialWork.SocialWorkServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/socialWork")
@CrossOrigin(origins = "*")
public class SocialWorkResource extends BaseControllerImpl<SocialWork, SocialWorkServiceImpl> {
}
