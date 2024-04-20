package com.sigis.sigis.service.type.document;

import com.sigis.sigis.domain.DocumentType;
import com.sigis.sigis.repository.DocumentTypeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DocumentTypeServiceImpl extends BaseServiceImpl<DocumentType, DocumentTypeRepository> implements IDocumentTypeService {
}
