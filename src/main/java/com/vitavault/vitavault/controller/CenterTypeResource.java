package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.CenterType;
import com.vitavault.vitavault.service.type.center.CenterTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/center")
@CrossOrigin(origins = "*")
public class CenterTypeResource extends BaseControllerImpl<CenterType, CenterTypeServiceImpl> {
}
