package com.vitavault.vitavault.service.type.document;

import com.vitavault.vitavault.model.domain.DocumentType;
import com.vitavault.vitavault.model.input.InputDocumentType;
import com.vitavault.vitavault.service.base.IBaseService;
import com.vitavault.vitavault.service.base.ICreateUpdate;

public interface IDocumentTypeService extends IBaseService<DocumentType>, ICreateUpdate<InputDocumentType> {
}
