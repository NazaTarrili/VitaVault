package com.sigis.sigis.service.street;

import com.sigis.sigis.domain.Street;
import com.sigis.sigis.repository.StreetRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class StreetServiceImpl extends BaseServiceImpl<Street, StreetRepository> implements IStreetService {
}
