package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.controller.base.IBaseController;
import com.vitavault.vitavault.domain.Plan;
import com.vitavault.vitavault.service.plan.IPlanService;
import com.vitavault.vitavault.util.responses.CustomResponses;
import com.vitavault.vitavault.util.responses.ResponseFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "/api/v3/plan")
@CrossOrigin(origins = "*")
public class PlanResource implements IBaseController<Plan> {
    @Autowired
    private IPlanService service;

    @Autowired
    private CustomResponses responses;

    @Override
    @PostMapping
    public ResponseEntity<ResponseFormatter> create(@RequestBody Plan entity) {
        try {
            if (service.create(entity)) return responses.created();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseFormatter> getAll() {
        try {
            return responses.founded(service.getAll());
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormatter> getByID(@PathVariable UUID id) {
        try {
            return responses.founded(service.getByID(id));
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormatter> update(@PathVariable UUID id, @RequestBody Plan entity) {
        try {
            if (service.update(id, entity)) return responses.updated();

            return responses.badRequest();
        } catch (Exception e) {
            return responses.error(e);
        }
    }

    @Override
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
