package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Center;
import com.vitavault.vitavault.service.center.CenterServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/center")
@CrossOrigin(origins = "*")
public class CenterResource extends BaseControllerImpl<Center, CenterServiceImpl> {
}
