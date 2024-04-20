package com.sigis.sigis.service.type.center;

import com.sigis.sigis.domain.CenterType;
import com.sigis.sigis.repository.CenterTypeRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CenterTypeServiceImpl extends BaseServiceImpl<CenterType, CenterTypeRepository> implements ICenterTypeService {
}
