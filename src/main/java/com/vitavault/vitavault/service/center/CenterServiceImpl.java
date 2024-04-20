package com.vitavault.vitavault.service.center;

import com.vitavault.vitavault.domain.Center;
import com.vitavault.vitavault.repository.CenterRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CenterServiceImpl extends BaseServiceImpl<Center, CenterRepository> implements ICenterService {
}
