package com.vitavault.vitavault.service.type.document;

import com.vitavault.vitavault.model.domain.DocumentType;
import com.vitavault.vitavault.repository.DocumentTypeRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DocumentTypeServiceImpl extends BaseServiceImpl<DocumentType, DocumentTypeRepository> implements IDocumentTypeService {
}
