package com.vitavault.vitavault.service.bed;

import com.vitavault.vitavault.model.domain.Bed;
import com.vitavault.vitavault.repository.BedRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BedServiceImpl extends BaseServiceImpl<Bed, BedRepository> implements IBedService {
}
