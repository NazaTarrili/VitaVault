package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.controller.base.BaseControllerImpl;
import com.vitavault.vitavault.domain.BedStatus;
import com.vitavault.vitavault.service.status.bed.BedStatusServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/status/bed", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BedStatusResource extends BaseControllerImpl<BedStatus, BedStatusServiceImpl> {
}
