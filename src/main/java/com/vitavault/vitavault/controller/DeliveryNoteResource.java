package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.DeliveryNote;
import com.vitavault.vitavault.service.deliveryNote.DeliveryNoteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/deliveryNote")
@CrossOrigin(origins = "*")
public class DeliveryNoteResource extends BaseControllerImpl<DeliveryNote, DeliveryNoteServiceImpl> {
}
