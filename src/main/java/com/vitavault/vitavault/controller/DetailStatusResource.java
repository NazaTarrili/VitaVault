package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.controller.base.BaseControllerImpl;
import com.vitavault.vitavault.domain.DetailStatus;
import com.vitavault.vitavault.service.status.detail.DetailStatusServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/status/detail", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DetailStatusResource extends BaseControllerImpl<DetailStatus, DetailStatusServiceImpl> {
}
