package com.vitavault.vitavault.service.type.document;

import com.vitavault.vitavault.model.domain.DocumentType;
import com.vitavault.vitavault.model.input.InputDocumentType;
import com.vitavault.vitavault.repository.DocumentTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.exceptionFactory.Property;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DocumentTypeServiceImpl extends BaseServiceImpl<DocumentType, DocumentTypeRepository> implements IDocumentTypeService {
    private final String className = DocumentType.class.getName();

    @Override
    public void create(InputDocumentType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        requestValidator.invalidRequest(new Property("name", input.name()), className);

        repository.save(new DocumentType(input.name()));
    }

    @Override
    public void update(UUID id, InputDocumentType input) {
        if (!input.hasData()) exceptionFactory.throwInvalidInput(className);

        DocumentType documentType = repository.findById(id).orElseThrow(() -> exceptionFactory.newNotFound(className));

        if (validate.isNonEmptyString(input.name()))
            documentType.setName(input.name());

        repository.save(documentType);
    }
}
