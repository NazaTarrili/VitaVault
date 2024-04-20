package com.sigis.sigis.service.bed;

import com.sigis.sigis.domain.Bed;
import com.sigis.sigis.repository.BedRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class BedServiceImpl extends BaseServiceImpl<Bed, BedRepository> implements IBedService {
}
