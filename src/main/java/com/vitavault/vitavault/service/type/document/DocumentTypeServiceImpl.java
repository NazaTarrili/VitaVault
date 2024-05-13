package com.vitavault.vitavault.service.type.document;

import com.vitavault.vitavault.model.domain.DocumentType;
import com.vitavault.vitavault.model.input.InputDocumentType;
import com.vitavault.vitavault.repository.DocumentTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import com.vitavault.vitavault.util.validateProperty.IValidateProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class DocumentTypeServiceImpl extends BaseServiceImpl<DocumentType, DocumentTypeRepository> implements IDocumentTypeService {
    @Autowired
    private IValidateProperty validate;

    @Override
    public void create(InputDocumentType input) {

    }

    @Override
    public void update(UUID id, InputDocumentType input) {

    }
}
