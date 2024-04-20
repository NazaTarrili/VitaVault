package com.sigis.sigis.service.periodicity;

import com.sigis.sigis.domain.Periodicity;
import com.sigis.sigis.repository.PeriodicityRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PeriodicityServiceImpl extends BaseServiceImpl<Periodicity, PeriodicityRepository> implements IPeriodicityService {
}
