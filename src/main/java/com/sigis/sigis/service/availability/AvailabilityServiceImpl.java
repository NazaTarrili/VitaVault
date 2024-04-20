package com.sigis.sigis.service.availability;

import com.sigis.sigis.domain.Availability;
import com.sigis.sigis.repository.AvailabilityRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AvailabilityServiceImpl extends BaseServiceImpl<Availability, AvailabilityRepository> implements IAvailabilityService {
}
