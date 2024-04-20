package com.vitavault.vitavault.service.city;

import com.vitavault.vitavault.domain.City;
import com.vitavault.vitavault.repository.CityRepository;
import com.vitavault.vitavault.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl extends BaseServiceImpl<City, CityRepository> implements ICityService {
}
