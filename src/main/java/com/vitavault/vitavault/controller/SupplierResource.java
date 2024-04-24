package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Supplier;
import com.vitavault.vitavault.service.supplier.SupplierServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/supplier")
@CrossOrigin(origins = "*")
public class SupplierResource extends BaseControllerImpl<Supplier, SupplierServiceImpl> {
}
