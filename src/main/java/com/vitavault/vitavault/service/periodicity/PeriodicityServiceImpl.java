package com.vitavault.vitavault.service.periodicity;

import com.vitavault.vitavault.domain.Periodicity;
import com.vitavault.vitavault.repository.PeriodicityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class PeriodicityServiceImpl extends BaseServiceImpl<Periodicity, PeriodicityRepository> implements IPeriodicityService {
}
