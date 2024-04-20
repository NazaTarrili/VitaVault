package com.sigis.sigis.service.city;

import com.sigis.sigis.domain.City;
import com.sigis.sigis.repository.CityRepository;
import com.sigis.sigis.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl extends BaseServiceImpl<City, CityRepository> implements ICityService {
}
