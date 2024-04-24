package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.domain.DocumentType;
import com.vitavault.vitavault.service.type.document.DocumentTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v3/type/document")
@CrossOrigin(origins = "*")
public class DocumentTypeResource extends BaseControllerImpl<DocumentType, DocumentTypeServiceImpl> {
}
