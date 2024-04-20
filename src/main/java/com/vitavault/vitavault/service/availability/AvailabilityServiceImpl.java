package com.vitavault.vitavault.service.availability;

import com.vitavault.vitavault.domain.Availability;
import com.vitavault.vitavault.repository.AvailabilityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AvailabilityServiceImpl extends BaseServiceImpl<Availability, AvailabilityRepository> implements IAvailabilityService {
}
