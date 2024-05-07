package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.SubscriptionPlan;
import com.vitavault.vitavault.service.subscriptionPlan.ISubscriptionPlanService;
import com.vitavault.vitavault.util.responses.CustomResponses;
import com.vitavault.vitavault.util.responses.ResponseFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/v3/subscriptionPlan")
@CrossOrigin(origins = "*")
public class SubscriptionPlanResource {
    @Autowired
    private ISubscriptionPlanService service;

    @Autowired
    private CustomResponses responses;

    @PostMapping
    public ResponseEntity<ResponseFormatter> create(@RequestBody SubscriptionPlan entity) {
        try {
            if (service.create(entity)) return responses.created();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseFormatter> getAll() {
        try {
            return responses.founded(service.getAll());
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormatter> getByID(@PathVariable UUID id) {
        try {
            return responses.founded(service.getByID(id));
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormatter> update(@PathVariable UUID id, @RequestBody SubscriptionPlan entity) {
        try {
            if (service.update(id, entity)) return responses.updated();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormatter> delete(@PathVariable UUID id) {
        try {
            if(service.delete(id)) return responses.deleted();

            return responses.notFounded();
        } catch (Exception e) {
            return responses.error(e);
        }
    }
}
