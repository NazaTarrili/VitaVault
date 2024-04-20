package com.sigis.sigis.service.center;

import com.sigis.sigis.domain.Center;
import com.sigis.sigis.repository.CenterRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CenterServiceImpl extends BaseServiceImpl<Center, CenterRepository> implements ICenterService {
}
