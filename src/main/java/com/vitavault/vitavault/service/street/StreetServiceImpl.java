package com.vitavault.vitavault.service.street;

import com.vitavault.vitavault.model.domain.Street;
import com.vitavault.vitavault.repository.StreetRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class StreetServiceImpl extends BaseServiceImpl<Street, StreetRepository> implements IStreetService {
}
