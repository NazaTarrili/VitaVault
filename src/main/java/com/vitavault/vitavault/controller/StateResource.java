package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.State;
import com.vitavault.vitavault.service.state.StateServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/state")
@CrossOrigin(origins = "*")
public class StateResource extends BaseControllerImpl<State, StateServiceImpl> {
}
