package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.SubscriptionStatus;
import com.vitavault.vitavault.service.status.subscription.SubscriptionStatusServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/status/subscription")
@CrossOrigin(origins = "*")
public class SubscriptionStatusResource extends BaseControllerImpl<SubscriptionStatus, SubscriptionStatusServiceImpl> {
}
