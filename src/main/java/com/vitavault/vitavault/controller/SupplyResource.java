package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Supply;
import com.vitavault.vitavault.service.supply.SupplyServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/supply")
@CrossOrigin(origins = "*")
public class SupplyResource extends BaseControllerImpl<Supply, SupplyServiceImpl> {
}
