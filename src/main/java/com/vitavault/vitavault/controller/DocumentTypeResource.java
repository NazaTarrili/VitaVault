package com.vitavault.vitavault.controller;

import com.vitavault.vitavault.model.domain.DocumentType;
import com.vitavault.vitavault.model.input.InputDocumentType;
import com.vitavault.vitavault.service.type.document.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


@Controller
public class DocumentTypeResource {
    @Autowired
    private IDocumentTypeService service;
    
    //Queries
    @QueryMapping
    public List<DocumentType> getAllDocumentType() {
        return service.getAll();
    }

    @QueryMapping
    public DocumentType getDocumentType(@Argument UUID id) {
        return service.getByID(id);
    }
    
    //Mutations
    @MutationMapping
    public void createDocumentType(@Argument InputDocumentType input) {
        service.create(input);
    }

    @MutationMapping
    public void updateDocumentType(@Argument UUID id, @Argument InputDocumentType input) {
        service.update(id, input);
    }

    @MutationMapping
    public void deleteDocumentType(@Argument UUID id) {
        service.delete(id);
    }
}
