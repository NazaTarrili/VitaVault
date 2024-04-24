package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.Plan;
import com.vitavault.vitavault.service.plan.PlanServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/plan")
@CrossOrigin(origins = "*")
public class PlanResource extends BaseControllerImpl<Plan, PlanServiceImpl> {
}
