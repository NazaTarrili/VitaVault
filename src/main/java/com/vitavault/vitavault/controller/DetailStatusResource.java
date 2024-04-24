package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.DetailStatus;
import com.vitavault.vitavault.service.status.detail.DetailStatusServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/status/detail")
@CrossOrigin(origins = "*")
public class DetailStatusResource extends BaseControllerImpl<DetailStatus, DetailStatusServiceImpl> {
}
