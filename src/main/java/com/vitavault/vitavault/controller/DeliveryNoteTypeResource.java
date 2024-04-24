package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.DeliveryNoteType;
import com.vitavault.vitavault.service.type.deliveryNote.DeliveryNoteTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/deliveryNote")
@CrossOrigin(origins = "*")
public class DeliveryNoteTypeResource extends BaseControllerImpl<DeliveryNoteType, DeliveryNoteTypeServiceImpl> {
}
