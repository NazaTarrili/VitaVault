package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.SupplyType;
import com.vitavault.vitavault.service.type.supply.SupplyTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/supply")
@CrossOrigin(origins = "*")
public class SupplyTypeResource extends BaseControllerImpl<SupplyType, SupplyTypeServiceImpl> {
}
