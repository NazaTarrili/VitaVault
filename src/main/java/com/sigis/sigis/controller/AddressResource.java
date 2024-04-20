package com.sigis.sigis.controller;

import com.sigis.sigis.controller.base.BaseControllerImpl;
import com.sigis.sigis.domain.Address;
import com.sigis.sigis.service.address.AddressServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/address", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class AddressResource extends BaseControllerImpl<Address, AddressServiceImpl> {
}
