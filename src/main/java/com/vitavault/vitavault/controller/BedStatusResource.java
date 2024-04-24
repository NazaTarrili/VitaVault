package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.BedStatus;
import com.vitavault.vitavault.service.status.bed.BedStatusServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/status/bed")
@CrossOrigin(origins = "*")
public class BedStatusResource extends BaseControllerImpl<BedStatus, BedStatusServiceImpl> {
}
