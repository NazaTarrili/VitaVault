package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.BillingDetail;
import com.vitavault.vitavault.service.billingDetail.BillingDetailServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/billingDetail")
@CrossOrigin(origins = "*")
public class BillingDetailResource extends BaseControllerImpl<BillingDetail, BillingDetailServiceImpl> {
}
